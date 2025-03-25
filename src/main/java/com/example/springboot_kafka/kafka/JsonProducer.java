package com.example.springboot_kafka.kafka;

import com.example.springboot_kafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User user) {
        LOGGER.info("Sending {} Message to topic {}", user.toString());
        Message<User> msg = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "javaGuides")
                .build();

        kafkaTemplate.send(msg);
    }
}
