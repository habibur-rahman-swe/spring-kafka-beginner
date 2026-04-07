package com.demo.producer.controller;

import java.util.UUID;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.producer.model.RiderLocation;

@Configuration
public class KafkaProducerStreams {
	
	@Bean
	public Supplier<RiderLocation> sendRiderLocation() {
		return () -> {
			RiderLocation location = new RiderLocation();
			location.setRiderId(UUID.randomUUID().toString());
			location.setLatitude(0.5 * System.currentTimeMillis());
			location.setLongitude(0.2 * System.currentTimeMillis());
			System.out.println("Sending: " + location.toString());
			return location;
		};
	}
}
