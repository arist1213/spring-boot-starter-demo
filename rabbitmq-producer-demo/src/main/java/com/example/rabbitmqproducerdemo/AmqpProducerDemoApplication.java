package com.example.rabbitmqproducerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AmqpProducerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpProducerDemoApplication.class, args).close();
	}
}
