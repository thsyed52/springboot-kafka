package com.example.springboot_kafka.controller;

import com.example.springboot_kafka.kafka.JsonProducer;
import com.example.springboot_kafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonController {
    private JsonProducer jsonProducer;

    public JsonController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity publish(@RequestBody User user) {
        jsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message send to kafka topic");
    }

}
