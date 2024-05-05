package com.pfe.MicroServiceC.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {
    @KafkaListener(topics = "MicroView", groupId = "group-id-2")
    public void listenGroup2(String message) {
        log.info("Received Message: " + message);
    }
}
