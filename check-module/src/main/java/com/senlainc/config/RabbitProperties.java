package com.senlainc.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class RabbitProperties {

    @Value("${queue.name}")
    private String MAKER_QUEUE_NAME;

    @Value("${exchange.name}")
    private String MAKER_EXCHANGE_NAME;

    @Value("${routing-key}")
    private String ROUTING_KEY;

    @Value("${checker.queue.name}")
    private String CHECKER_QUEUE_NAME;

    @Value("${checker.exchange.name}")
    private String CHECKER_EXCHANGE_NAME;

    @Value("${checker.routing-key}")
    private String CHECKER_ROUTING_KEY;
}
