package com.jonasesteves.algasensors.temperaturemonitoring.domain.repository;

import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorAlert;
import com.jonasesteves.algasensors.temperaturemonitoring.domain.model.SensorId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorAlertRepository extends JpaRepository<SensorAlert, SensorId> {
}
