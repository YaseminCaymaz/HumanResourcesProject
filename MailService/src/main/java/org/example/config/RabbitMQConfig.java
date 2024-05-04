package org.example.config;

import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
public class RabbitMQConfig {

    private String queueMailSender="mail-sender-queue";

    @Bean
    public Queue queueRegister(){
        return new Queue(queueMailSender);
    }

}