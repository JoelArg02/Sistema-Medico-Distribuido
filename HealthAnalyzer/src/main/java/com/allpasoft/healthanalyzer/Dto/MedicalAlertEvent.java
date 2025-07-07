package com.allpasoft.healthanalyzer.Dto;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class MedicalAlertEvent {
    private String alertId;
    private String type;
    private String deviceId;
    private Double value;
    private Double threshold;
    private Instant timestamp;

    public static MedicalAlertEvent create(String type, String deviceId, Double value, Double threshold) {
        MedicalAlertEvent evt = new MedicalAlertEvent();
        evt.setAlertId("ALT-" + UUID.randomUUID());
        evt.setType(type);
        evt.setDeviceId(deviceId);
        evt.setValue(value);
        evt.setThreshold(threshold);
        evt.setTimestamp(Instant.now());
        return evt;
    }
}