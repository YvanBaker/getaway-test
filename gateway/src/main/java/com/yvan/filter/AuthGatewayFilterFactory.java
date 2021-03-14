package com.yvan.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author v_yangfeng01
 * @date 2021/2/18
 */
@Component
@Order(1)
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private static final Logger logger = Logger.getLogger(String.valueOf(AuthGatewayFilterFactory.class));

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)}");

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            logger.info("进入拦截器");
            String rawQuery = exchange.getRequest().getURI().getPath();
            Matcher matcher = PATTERN.matcher(rawQuery);
            while (matcher.find()) {
                logger.info(matcher.group().substring(1, matcher.group().length() - 1));
            }
            logger.info(rawQuery);

            String s = "三国恋";
            Flux<DataBuffer> body1 = exchange.getRequest().getBody();
            ServerHttpRequest.Builder request = exchange.getRequest().mutate();
            request.header("X-test", "123");
            return chain.filter(exchange.mutate().request(request.build()).build());
        };
    }
}
