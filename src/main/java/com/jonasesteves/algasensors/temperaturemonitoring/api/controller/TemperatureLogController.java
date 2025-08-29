package com.jonasesteves.algasensors.temperaturemonitoring.api.controller;

import com.jonasesteves.algasensors.temperaturemonitoring.api.model.TemperatureLogOutput;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorId;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.TemperatureLog;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.repository.TemperatureLogRepository;
import io.hypersistence.tsid.TSID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures")
public class TemperatureLogController {
    private final TemperatureLogRepository temperatureLogRepository;

    public TemperatureLogController(TemperatureLogRepository temperatureLogRepository) {
        this.temperatureLogRepository = temperatureLogRepository;
    }

    @GetMapping
    public Page<TemperatureLogOutput> search(@PathVariable TSID sensorId, @PageableDefault Pageable pageable) {
        Page<TemperatureLog> logs = temperatureLogRepository.findAllBySensorId(new SensorId(sensorId), pageable);

        return logs.map(
                temperatureLog -> TemperatureLogOutput.builder()
                        .id(temperatureLog.getId().getValue())
                        .value(temperatureLog.getValue())
                        .registeredAt(temperatureLog.getRegisteredAt())
                        .sensorId(temperatureLog.getSensorId().getValue())
                        .build()
        );
    }
}
