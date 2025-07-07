package com.allpasoft.healthanalyzer.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class NewVitalSignEvent {
    private String eventId;
    private String deviceId;
    private String type;
    private Double value;
    private Instant timestamp;
}
