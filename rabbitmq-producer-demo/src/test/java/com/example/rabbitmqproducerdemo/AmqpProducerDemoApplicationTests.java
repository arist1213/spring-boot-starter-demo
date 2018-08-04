package com.example.rabbitmqproducerdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpProducerDemoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Value("${demo.rabbitmq.exchange}")
	String topicExchangeName;

	@Value("${demo.rabbitmq.exchange}")
	String routingKey;

	@Test
	public void contextLoads() {
	}

	@Test
	public void sendMessageToAmqp() {
		System.out.println("Sending message ...");
		rabbitTemplate.convertAndSend(topicExchangeName, routingKey, "Hello from RabbitMQ!");
	}

}
