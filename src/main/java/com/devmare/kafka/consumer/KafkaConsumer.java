package com.devmare.kafka.consumer;

import com.devmare.kafka.payload.Developer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    //    @KafkaListener(
//            topics = "devmare",
//            groupId = "devGroup"
//    )
    public void consumeMessage(String message) {
        log.info("Cosuming the message from devmare topic: {}", message);
    }

    @KafkaListener(
            topics = "devmare",
            groupId = "devGroup"
    )
    public void consumeJsonMessage(Developer developer) {
        log.info("Cosuming the json message from devmare topic: {}", developer.toString());
    }
}
