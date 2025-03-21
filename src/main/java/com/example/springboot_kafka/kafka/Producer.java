package com.example.springboot_kafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        LOGGER.info(String.format("Message Sent: %s", message));
        kafkaTemplate.send("javaGuides", message);
    }
}
