package com.allpasoft.patientdatacollector.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class NewVitalSignEvent {
    private String eventId;
    private String deviceId;
    private String type;
    private Double value;
    private Instant timestamp;

    public static NewVitalSignEvent from(String deviceId, String type, Double value, Instant timestamp) {
        NewVitalSignEvent evt = new NewVitalSignEvent();
        evt.setEventId("EVT-" + UUID.randomUUID());
        evt.setDeviceId(deviceId);
        evt.setType(type);
        evt.setValue(value);
        evt.setTimestamp(timestamp);
        return evt;
    }
}
