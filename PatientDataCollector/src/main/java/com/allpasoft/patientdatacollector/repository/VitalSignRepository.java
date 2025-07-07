package com.allpasoft.patientdatacollector.repository;

import com.allpasoft.patientdatacollector.entity.VitalSign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalSignRepository extends JpaRepository<VitalSign, Long> {
    List<VitalSign> findByDeviceId(String deviceId);

}
