package top.zhijie.gatewayservice.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class InvalidParameterGatewayFilterFactory extends AbstractGatewayFilterFactory<InvalidParameterGatewayFilterFactory.Config> {

    public static final String NAME = "name";
    public static final String VALUE = "value";

    public InvalidParameterGatewayFilterFactory() {
        super(Config.class);  // 指定Config类
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(NAME, VALUE);  // 配置字段的顺序
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            // 确保配置的name和value不为空
            if (StringUtils.isNotBlank(config.getName()) && StringUtils.isNotBlank(config.getValue())) {
                // 获取请求对象
                ServerHttpRequest request = exchange.getRequest();
                // 获取请求的查询参数
                String value = request.getQueryParams().getFirst(config.getName()); // getFirst避免空值问题

                if (value != null && config.getValue().equalsIgnoreCase(value)) {
                    // 如果查询参数与配置的值匹配，则抛出异常
                    throw new RuntimeException("非法参数：" + config.getName() + "=" + value);
                }
            }
            // 如果没有问题，继续请求链
            return chain.filter(exchange);
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        private String name;
        private String value;
    }
}
