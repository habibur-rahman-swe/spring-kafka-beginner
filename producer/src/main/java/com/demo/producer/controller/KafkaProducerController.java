package com.demo.producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class KafkaProducerController {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducerController(KafkaTemplate<String, String> kakfaTemplate) {
		this.kafkaTemplate = kakfaTemplate;
	}

	@PostMapping("/send")
	public String sendMessage(@RequestParam String message) {
		kafkaTemplate.send("my-topic", message);
		
		return "Message sent to Kafka: " + message;
	}

}
