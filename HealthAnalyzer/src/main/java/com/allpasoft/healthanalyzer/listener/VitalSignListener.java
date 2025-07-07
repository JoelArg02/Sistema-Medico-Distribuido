package com.allpasoft.healthanalyzer.listener;

import com.allpasoft.healthanalyzer.Dto.NewVitalSignEvent;
import com.allpasoft.healthanalyzer.service.AlertService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VitalSignListener {

    @Autowired
    private AlertService alertService;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "vital.signs.cola")
    public void recibirEvento(String mensaje) {
        try {
            NewVitalSignEvent evento = objectMapper.readValue(mensaje, NewVitalSignEvent.class);
            alertService.procesarEvento(evento);
            System.out.println("Evento recibido: " + evento);
        } catch (Exception e) {
            System.err.println("Error al procesar evento: " + e.getMessage());
        }
    }
}
