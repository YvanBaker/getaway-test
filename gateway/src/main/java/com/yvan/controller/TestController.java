package com.yvan.controller;

import com.yvan.vo.TestResponse;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author v_yangfeng01
 * @date 2021/2/12
 */
@RestController
public class TestController {



    @GetMapping("/test")
    public Mono<TestResponse> test() {
        TestResponse testResponse = new TestResponse();
        return Mono.just(testResponse);
    }

    @GetMapping("/routes")
    public Mono<List<Map<String, Object>>> routes() {
        Map<String, RouteDefinition> routeDefs = new HashMap<>();
        List<Route> routes = new ArrayList<>();

        routeDefs.put("1", new RouteDefinition());
        routeDefs.put("2", new RouteDefinition());

        Mono<Map<String, RouteDefinition>> routeDefss = Mono.just(routeDefs);
        Mono<List<Route>> routess = Mono.just(routes);

        return Mono.zip(routeDefss, routess).map(tuple -> {
            Map<String, RouteDefinition> defs = tuple.getT1();
            List<Route> routeList = tuple.getT2();
            List<Map<String, Object>> allRoutes = new ArrayList<>();

            routeList.forEach(route -> {
                Map<String, Object> r = new HashMap<>();
                r.put("route_id", route.getId());
                r.put("order", route.getOrder());

                if (defs.containsKey(route.getId())) {
                    r.put("route_definition", defs.get(route.getId()));
                } else {
                    Map<String, Object> obj = new HashMap<>();

                    obj.put("predicate", route.getPredicate().toString());
                    if (!route.getFilters().isEmpty()) {
                        List<String> filters = new ArrayList<>();
                        for (GatewayFilter filter : route.getFilters()) {
                            filters.add(filter.toString());
                        }

                        obj.put("filters", filters);
                    }
                    if (!obj.isEmpty()) {
                        r.put("route_object", obj);
                    }
                }

                allRoutes.add(r);
            });

            return allRoutes;
        });
    }

}
