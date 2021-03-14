package com.yvan.config;

import com.yvan.vo.dynamicroute.DynamicRouteRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */

@Component
@ConfigurationProperties(prefix = "gateway")
public class GatewayConfig extends DynamicRouteRequest {

}
