package com.jonasesteves.algasensors.temperaturemonitoring.api.controller;

import com.jonasesteves.algasensors.temperaturemonitoring.api.model.SensorAlertInput;
import com.jonasesteves.algasensors.temperaturemonitoring.api.model.SensorAlertOutput;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorAlert;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorId;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.repository.SensorAlertRepository;
import io.hypersistence.tsid.TSID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/sensors/{sensorId}/alert")
public class SensorAlertController {
    private final SensorAlertRepository sensorAlertRepository;

    public SensorAlertController(SensorAlertRepository sensorAlertRepository) {
        this.sensorAlertRepository = sensorAlertRepository;
    }

    @GetMapping
    public SensorAlertOutput findById(@PathVariable TSID sensorId) {
        SensorAlert sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToOutput(sensorAlert);
    }

    @PutMapping
    public SensorAlertOutput updateOrCreate(@PathVariable TSID sensorId, @RequestBody SensorAlertInput sensorAlertInput) {
        SensorAlert sensorAlert = findByIdOrDefault(sensorId, sensorAlertInput);
        sensorAlert = sensorAlertRepository.saveAndFlush(sensorAlert);
        return convertToOutput(sensorAlert);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable TSID sensorId) {
        SensorAlert sensorAlert = sensorAlertRepository.findById(new SensorId(sensorId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        sensorAlertRepository.delete(sensorAlert);
    }

    private SensorAlert findByIdOrDefault(TSID sensorId, SensorAlertInput sensorAlertInput) {
        return sensorAlertRepository.findById(new SensorId(sensorId))
                .orElse(SensorAlert.builder()
                        .id(new SensorId(sensorId))
                        .minTemperature(sensorAlertInput.getMinTemperature())
                        .maxTemperature(sensorAlertInput.getMaxTemperature())
                        .build());
    }

    private static SensorAlertOutput convertToOutput(SensorAlert sensorAlert) {
        return SensorAlertOutput.builder()
                .id(sensorAlert.getId().getValue())
                .minTemperature(sensorAlert.getMinTemperature())
                .maxTemperature(sensorAlert.getMaxTemperature())
                .build();
    }
}
