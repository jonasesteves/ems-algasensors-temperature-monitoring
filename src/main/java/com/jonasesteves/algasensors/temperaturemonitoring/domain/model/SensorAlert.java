package com.jonasesteves.algasensors.temperaturemonitoring.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SensorAlert {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private SensorId id;
    private Double minTemperature;
    private Double maxTemperature;

    private SensorAlert(){}

    public SensorAlert(SensorId id, Double minTemperature, Double maxTemperature) {
        this.id = id;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public SensorId getId() {
        return id;
    }

    public void setId(SensorId id) {
        this.id = id;
    }

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
        SensorAlert that = (SensorAlert) o;
        return Objects.equals(id, that.id) && Objects.equals(minTemperature, that.minTemperature) && Objects.equals(maxTemperature, that.maxTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minTemperature, maxTemperature);
    }

    @Override
    public String toString() {
        return "SensorAlert{" +
                "id=" + id +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SensorId id;
        private Double minTemperature;
        private Double maxTemperature;

        public Builder id(SensorId id) {
            this.id = id;
            return this;
        }

        public Builder minTemperature(Double minTemperature) {
            this.minTemperature = minTemperature;
            return this;
        }

        public Builder maxTemperature(Double maxTemperature) {
            this.maxTemperature = maxTemperature;
            return this;
        }

        public SensorAlert build() {
            return new SensorAlert(this.id, this.minTemperature, this.maxTemperature);
        }

        @Override
        public String toString() {
            return "SensorAlert.Builder{" +
                    "id=" + id +
                    ", minTemperature=" + minTemperature +
                    ", maxTemperature=" + maxTemperature +
                    '}';
        }
    }
}
