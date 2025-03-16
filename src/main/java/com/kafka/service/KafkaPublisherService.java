package com.kafka.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.SendResult;

@Service
public class KafkaPublisherService {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Value("${kafka-topic}")
	private String kafkaTopic;

	public void publishMessage(String message) {
		try {
			CompletableFuture<SendResult<String, String>> resultCompletableFuture = kafkaTemplate.send(kafkaTopic,
					message);
			System.out.println(" Offset [ " + resultCompletableFuture.get().getRecordMetadata().offset() + " }");
			System.out.println(" metadeta " + resultCompletableFuture.get().getRecordMetadata());
			System.out.println(" Producer Record " + resultCompletableFuture.get().getProducerRecord());
			System.out.println(" Partition " + resultCompletableFuture.get().getRecordMetadata().partition());

		} catch (Exception e) {

		}
	}
}
