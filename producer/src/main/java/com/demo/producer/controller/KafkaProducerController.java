package com.demo.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.producer.model.RiderLocation;

//@RestController
//@RequestMapping("/api/producer")
//public class KafkaProducerController {
//
//	private final KafkaTemplate<String, RiderLocation> kafkaTemplate;
//
//	public KafkaProducerController(KafkaTemplate<String, RiderLocation> kakfaTemplate) {
//		this.kafkaTemplate = kakfaTemplate;
//	}
//
//	@PostMapping("/send")
//	public String sendMessage(@RequestBody RiderLocation riderLocation) {
//		
//		kafkaTemplate.send("rider-topic", riderLocation);
//		
//		return "Message sent to Kafka: " + riderLocation.toString();
//	}
//
//}
