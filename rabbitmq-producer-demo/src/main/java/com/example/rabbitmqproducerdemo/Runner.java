package com.example.rabbitmqproducerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * created by yanming on 2018/8/4
 */
@Component
public class Runner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${demo.rabbitmq.exchange}")
    String topicExchangeName;

    @Value("${demo.rabbitmq.routingkey}")
    String routingKey;

    @Override
    public void run(String... args) throws Exception {
        log.info("Sending message ...");
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, "Hello from Runner.");
    }
}
