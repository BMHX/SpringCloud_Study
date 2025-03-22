package top.zhijie.gatewayservice.predicate;


import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalTime;
import java.util.function.Predicate;

@Component // 确保 Spring 能够扫描到这个组件
public class TimeRangeRoutePredicateFactory extends AbstractRoutePredicateFactory<TimeRangeRoutePredicateFactory.Config> {

    public TimeRangeRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            LocalTime now = LocalTime.now();
            return now.isAfter(config.getStartTime()) && now.isBefore(config.getEndTime());
        };
    }

    @Data
    public static class Config {
        private LocalTime startTime;
        private LocalTime endTime;
    }
}
