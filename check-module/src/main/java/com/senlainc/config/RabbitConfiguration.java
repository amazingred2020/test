package com.senlainc.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableRabbit
@ComponentScan("com.senlainc")
@PropertySource("classpath:rabbitmq.properties")
public class RabbitConfiguration {

    @Autowired
    private RabbitProperties properties;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("rabbitmq");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public Queue makerQueue(){
        return new Queue(properties.getMakerQueueName(), true);
    }

    @Bean
    public DirectExchange makerExchange(){
        return new DirectExchange(properties.getMakerExchangeName());
    }

    @Bean
    Binding makerExchangeBinding(DirectExchange directExchange, @Qualifier("makerQueue") Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(properties.getMakerRoutingKey());
    }

    @Bean
    public Queue checkerQueue(){
        return new Queue(properties.getCheckerQueueName(), true);
    }

    @Bean
    public TopicExchange checkerExchange(){
        return new TopicExchange(properties.getCheckerExchangeName());
    }

    @Bean
    Binding checkerExchangeBinding(TopicExchange topicExchange, @Qualifier("checkerQueue") Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with(properties.getCheckerRoutingKey());
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.declareQueue(makerQueue());
        rabbitAdmin.declareExchange(makerExchange());
        rabbitAdmin.declareBinding(makerExchangeBinding(makerExchange(),makerQueue()));
        rabbitAdmin.declareQueue(checkerQueue());
        rabbitAdmin.declareExchange(checkerExchange());
        rabbitAdmin.declareBinding(checkerExchangeBinding(checkerExchange(),checkerQueue()));
        return rabbitAdmin;
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory listenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(messageConverter());
        return factory;
    }
}