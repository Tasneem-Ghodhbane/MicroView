package com.pfe.MicroServiceB.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class KafkaConsumerService {
    @KafkaListener(topics = "MicroView", groupId = "group-id-1")
    public void listenGroup1(String message) {
        System.out.println("Received Message: " + message);
    }
}
