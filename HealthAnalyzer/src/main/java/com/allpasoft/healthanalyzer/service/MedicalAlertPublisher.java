package com.allpasoft.healthanalyzer.service;

import com.allpasoft.healthanalyzer.config.RabbitMQConfig;
import com.allpasoft.healthanalyzer.entity.MedicalAlert;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MedicalAlertPublisher {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public MedicalAlertPublisher(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    public void publish(MedicalAlert alert) {
        try {
            String json = objectMapper.writeValueAsString(alert);
            amqpTemplate.convertAndSend(RabbitMQConfig.ALERT_QUEUE, json);
            System.out.println("Alerta enviada a RabbitMQ: " + json);
        } catch (Exception e) {
            System.err.println("Fallo al publicar alerta: " + e.getMessage());
        }
    }

}
