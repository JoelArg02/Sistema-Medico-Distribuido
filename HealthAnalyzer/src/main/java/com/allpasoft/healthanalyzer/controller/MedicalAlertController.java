package com.allpasoft.healthanalyzer.controller;

import com.allpasoft.healthanalyzer.entity.MedicalAlert;
import com.allpasoft.healthanalyzer.repository.MedicalAlertRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class MedicalAlertController {

    private final MedicalAlertRepository repository;

    public MedicalAlertController(MedicalAlertRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MedicalAlert> obtenerAlertas() {
        return repository.findAll();
    }
}
