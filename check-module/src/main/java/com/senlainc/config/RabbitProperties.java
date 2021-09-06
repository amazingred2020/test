package com.senlainc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class RabbitProperties {

    @Value("${maker.queue.name}")
    private String makerQueueName;

    @Value("${maker.exchange.name}")
    private String makerExchangeName;

    @Value("${maker.routing-key}")
    private String makerRoutingKey;

    @Value("${checker.queue.name}")
    private String checkerQueueName;

    @Value("${checker.exchange.name}")
    private String checkerExchangeName;

    @Value("${checker.routing-key}")
    private String checkerRoutingKey;
}
