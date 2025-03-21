package com.devmare.kafka.controller;

import com.devmare.kafka.payload.Developer;
import com.devmare.kafka.producer.KafkaJsonProducer;
import com.devmare.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Response Queued...");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Developer developer) {
        kafkaJsonProducer.sendMessage(developer);
        return ResponseEntity.ok("Response Queued as JSON...");
    }
}
