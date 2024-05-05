package com.pfe.MicroServiceC.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "MicroView", groupId = "group-id-2")
    public void listenGroup2(String message) {
        System.out.println("Received Message: " + message);
    }
}
