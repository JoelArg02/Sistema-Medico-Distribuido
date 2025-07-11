package com.allpasoft.healthanalyzer.config;

import com.allpasoft.healthanalyzer.entity.MedicalAlert;
import com.allpasoft.healthanalyzer.repository.MedicalAlertRepository;
import com.allpasoft.healthanalyzer.service.MedicalAlertPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeviceOfflineScheduler {

    private final MedicalAlertPublisher publisher;
    private final MedicalAlertRepository repository;

    public DeviceOfflineScheduler(MedicalAlertPublisher publisher, MedicalAlertRepository repository) {
        this.publisher = publisher;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 21600000)
    public void verificarDispositivosInactivos() {
        MedicalAlert alerta = MedicalAlert.fromEvent(
                "DeviceOfflineAlert",
                "D001",
                0.0,
                0.0
        );
        repository.save(alerta);
        publisher.publish(alerta);
        System.out.println("⚠️ Dispositivo inactivo detectado (simulado): " + alerta.getDeviceId());
    }
}
