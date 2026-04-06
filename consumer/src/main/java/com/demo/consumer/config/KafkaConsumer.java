package com.demo.consumer.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.demo.consumer.model.RiderLocation;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "rider-topic", groupId = "my-group")
	public void listen1(RiderLocation message) {
		System.out.println("Consumer1: " + message.toString());
	}
	
	@KafkaListener(topics = "rider-topic", groupId = "my-group")
	public void listen2(RiderLocation message) {
		System.out.println("Consumer2: " + message.toString());
	}
	
	@KafkaListener(topics = "rider-topic", groupId = "my-group")
	public void listen3(RiderLocation message) {
		System.out.println("Consumer3: " + message.toString());
	}

}
