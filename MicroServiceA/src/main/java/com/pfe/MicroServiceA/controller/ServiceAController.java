package com.pfe.MicroServiceA.controller;

import com.pfe.MicroServiceA.services.KafkaProducerService;
import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceAController {

    private KafkaProducerService kafkaProducerService;

    public ServiceAController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Service A";
    }

    @PostMapping("/produce")
    public void sendMessageToKafka(@RequestBody String message) {
        kafkaProducerService.sendMessage(message);
    }
}

