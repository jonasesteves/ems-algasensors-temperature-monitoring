package com.jonasesteves.algasensors.temperaturemonitoring.domain.repository;

import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorId;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorMonitoring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorMonitoringRepository extends JpaRepository<SensorMonitoring, SensorId> {
}
