package com.demo.consumer.config;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.consumer.model.RiderLocation;

@Configuration
public class KafkaConsumerStreams {

	@Bean
	public Consumer<RiderLocation> processRiderLocation() {
		return message -> System.out.println("Consumer1: " + message.toString());
	}
}
