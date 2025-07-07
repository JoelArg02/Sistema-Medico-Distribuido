package com.allpasoft.patientdatacollector.controller;

import com.allpasoft.patientdatacollector.dto.VitalSignDto;
import com.allpasoft.patientdatacollector.entity.VitalSign;
import com.allpasoft.patientdatacollector.service.VitalSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vital-signs")
public class VitalSignController {

    @Autowired
    private VitalSignService service;

    @PostMapping
    public void guardarVitalSign(@RequestBody VitalSignDto dto) {
        service.guardarVitalSign(dto);
    }

    @GetMapping("/{deviceId}")
    public List<VitalSign> obtenerPorDispositivo(@PathVariable String deviceId) {
        return service.listarPorDispositivo(deviceId);
    }

    @GetMapping
    public List<VitalSign> listarTodos() {
        return service.listarTodos();
    }
}
