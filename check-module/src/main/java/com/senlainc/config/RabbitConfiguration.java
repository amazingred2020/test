package com.senlainc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
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
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public Queue queue(){
        return new Queue(properties.getMAKER_QUEUE_NAME(), true);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(properties.getMAKER_EXCHANGE_NAME());
    }

    @Bean
    Binding exchangeBinding(DirectExchange directExchange, Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(properties.getROUTING_KEY());
    }

    @Bean
    public Queue checkerQueue(){
        return new Queue(properties.getCHECKER_QUEUE_NAME(), true);
    }

    @Bean
    public DirectExchange checkerExchange(){
        return new DirectExchange(properties.getCHECKER_EXCHANGE_NAME());
    }

    @Bean
    Binding checkerExchangeBinding(DirectExchange directExchange, Queue queue){
        return BindingBuilder.bind(queue).to(directExchange).with(properties.getCHECKER_ROUTING_KEY());
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
        rabbitAdmin.declareQueue(queue());
        rabbitAdmin.declareExchange(exchange());
        rabbitAdmin.declareBinding(exchangeBinding(exchange(),queue()));
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
        rabbitTemplate.setRoutingKey(properties.getROUTING_KEY());
        rabbitTemplate.setExchange(properties.getMAKER_EXCHANGE_NAME());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public RabbitTemplate checkerTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setRoutingKey(properties.getCHECKER_ROUTING_KEY());
        rabbitTemplate.setExchange(properties.getCHECKER_EXCHANGE_NAME());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory listenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }
}
