package com.example.rabbitmqconsumerdemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * created by yanming on 2018/8/4
 */
@Component
@RabbitListener(queues="${demo.rabbitmq.queue}")
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("receiveMessage: {}", message);
    }
}