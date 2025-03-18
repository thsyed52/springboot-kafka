package com.example.springboot_kafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class kafkaTopicConfig {

    public NewTopic javaGuidesTopic() {
        return TopicBuilder.name("javaGuides").build();
    }
}
