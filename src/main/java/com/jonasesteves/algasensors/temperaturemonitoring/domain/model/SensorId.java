package com.jonasesteves.algasensors.temperaturemonitoring.domain.model;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SensorId implements Serializable {
    /* (10.4) */

    private TSID value;

    protected SensorId() {
    }

    public SensorId(TSID value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    public SensorId(Long value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    public SensorId(String value) {
        Objects.requireNonNull(value);
        this.value = TSID.from(value);
    }

    public TSID getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SensorId sensorId = (SensorId) o;
        return Objects.equals(value, sensorId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
