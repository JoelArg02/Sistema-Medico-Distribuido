package com.allpasoft.healthanalyzer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "medical_alerts")
@Getter
@Setter
public class MedicalAlert {

    @Id
    @Column(name = "alert_id")
    private String alertId;

    private String type;

    @Column(name = "device_id")
    private String deviceId;

    private Double value;

    private Double threshold;

    private Instant timestamp;

    public static MedicalAlert fromEvent(String type, String deviceId, Double value, Double threshold) {
        MedicalAlert alert = new MedicalAlert();
        alert.setAlertId("ALT-" + UUID.randomUUID());
        alert.setType(type);
        alert.setDeviceId(deviceId);
        alert.setValue(value);
        alert.setThreshold(threshold);
        alert.setTimestamp(Instant.now());
        return alert;
    }
}
