package com.yvan.listener;

import com.yvan.config.GatewayConfig;
import com.yvan.service.impl.DynamicRouteServiceImpl;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */
@Component
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private GatewayConfig gatewayConfig;

    @Resource
    private DynamicRouteServiceImpl dynamicRouteService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            dynamicRouteService.add(gatewayConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
