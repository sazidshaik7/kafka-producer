package com.kafka.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.service.KafkaPublisherService;

@RestController
@RequestMapping("/producer")
public class KafkaProducerController {

	@Autowired
	KafkaPublisherService kafkaPublisherService;

	@GetMapping("/sendMessage/{message}")
	public String sendMessage(@PathVariable("message") String message) {
//		for (int i = 0; i <= 10000; i++) {
//			kafkaPublisherService.publishMessage(message + " : " + i);
//		}
		kafkaPublisherService.publishMessage(message);
		return "Message Published Successfully";
	}
}
