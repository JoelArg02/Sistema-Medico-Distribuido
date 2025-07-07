package com.allpasoft.patientdatacollector.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VitalSignDto {
    private String deviceId;
    private String type;
    private Double value;
}
