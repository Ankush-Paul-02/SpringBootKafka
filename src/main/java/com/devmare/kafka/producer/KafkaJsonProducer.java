package com.devmare.kafka.producer;

import com.devmare.kafka.payload.Developer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Developer> kafkaTemplate;

    public void sendMessage(Developer developer) {
        Message<Developer> message = MessageBuilder
                .withPayload(developer)
                .setHeader(KafkaHeaders.TOPIC, "devmare")
                .build();
        kafkaTemplate.send(message);
    }
}
