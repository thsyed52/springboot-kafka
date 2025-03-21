package com.example.springboot_kafka.controller;


import com.example.springboot_kafka.kafka.Producer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")

public class messageController {

    private Producer kafkaProducer;
    public messageController(Producer kafkaProducerArg) {
        this.kafkaProducer = kafkaProducerArg;
    }

    // http:localhost:8080/api/v1/kafka/publish?message=Testing message 1
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return ResponseEntity.ok("Message published");
    }
}
