package com.jonasesteves.algasensors.temperaturemonitoring.api.model;

import java.util.Objects;

public class SensorAlertInput {
    private Double minTemperature;
    private Double maxTemperature;

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SensorAlertInput that = (SensorAlertInput) o;
        return Objects.equals(minTemperature, that.minTemperature) && Objects.equals(maxTemperature, that.maxTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minTemperature, maxTemperature);
    }

    @Override
    public String toString() {
        return "SensorAlertInput{" +
                "minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }
}
