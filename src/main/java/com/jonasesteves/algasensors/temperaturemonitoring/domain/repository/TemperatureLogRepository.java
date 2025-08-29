package com.jonasesteves.algasensors.temperaturemonitoring.domain.repository;

import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorId;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.TemperatureLog;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.TemperatureLogId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureLogRepository extends JpaRepository<TemperatureLog, TemperatureLogId> {
    Page<TemperatureLog> findAllBySensorId(SensorId sensorId, Pageable pageable);
}
