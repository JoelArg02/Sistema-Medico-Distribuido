package com.allpasoft.healthanalyzer.repository;

import com.allpasoft.healthanalyzer.entity.MedicalAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAlertRepository extends JpaRepository<MedicalAlert, String> {
}
