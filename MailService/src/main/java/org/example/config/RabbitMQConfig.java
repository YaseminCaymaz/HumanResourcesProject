package org.example.config;

import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class RabbitMQConfig {

    private String queueMailSender="mail-sender-queue";


    @Bean
    public Queue queueRegister(){
        Queue queue = new Queue(queueMailSender);
        return queue;
    }



}