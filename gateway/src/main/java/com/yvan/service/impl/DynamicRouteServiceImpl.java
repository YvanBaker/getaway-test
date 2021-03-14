package com.yvan.service.impl;

import com.yvan.vo.dynamicroute.DynamicRouteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */
@Service("dynamicRouteService")
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    /**
     * 添加路由
     *
     * @param request 信息
     * @throws Exception 异常处理
     */
    public void add(DynamicRouteRequest request) throws Exception {
        RouteDefinition routeDefinition = assembleRouteDefinition(request);

        routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    private RouteDefinition assembleRouteDefinition(DynamicRouteRequest request) throws Exception {
        if (!request.isVaild()) {
            throw new Exception("参数错误");
        }
        RouteDefinition routeDefinition = new RouteDefinition();
        routeDefinition.setId(request.getCode());


        // 设置断言
        List<PredicateDefinition> pdList = new ArrayList<>();
        PredicateDefinition pathPredicate = createPredicateDefinition("Path", request.getPath());
        PredicateDefinition methodPredicate = createPredicateDefinition("Method", request.getMethod());
        pdList.add(pathPredicate);
        pdList.add(methodPredicate);
        routeDefinition.setPredicates(pdList);

        // 设置过滤器
        List<FilterDefinition> filters = new ArrayList<>();
        FilterDefinition auth = createFilterDefinition("Auth");
        filters.add(auth);
        routeDefinition.setFilters(filters);

        URI uri = UriComponentsBuilder.fromHttpUrl(request.getUri()).build().toUri();
        routeDefinition.setUri(uri);

        return routeDefinition;
    }

    /**
     * 获取 对应的 filter
     *
     * @param name 名字
     * @return
     */
    private FilterDefinition createFilterDefinition(String name) {
        Map<String, String> args = new HashMap<>();
        args.put("_genkey_0_", "");

        FilterDefinition filterDefinition = new FilterDefinition();
        filterDefinition.setName(name);
        filterDefinition.setArgs(args);

        return filterDefinition;
    }

    /**
     * 设置断言的 json 数据
     *
     * @param name 断言的名字
     * @param arg  参数
     * @return 断言
     */
    private PredicateDefinition createPredicateDefinition(String name, String arg) {
        Map<String, String> args = new HashMap<>();
        args.put("_genkey_0", arg);

        PredicateDefinition predicate = new PredicateDefinition();
        predicate.setName(name);
        predicate.setArgs(args);

        return predicate;
    }
}
