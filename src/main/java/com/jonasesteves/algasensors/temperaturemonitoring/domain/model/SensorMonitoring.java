package com.jonasesteves.algasensors.temperaturemonitoring.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class SensorMonitoring {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private SensorId id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;

    public SensorMonitoring() {
    }

    public SensorMonitoring(SensorId id, Double lastTemperature, OffsetDateTime updatedAt, Boolean enabled) {
        this.id = id;
        this.lastTemperature = lastTemperature;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
    }

    public SensorId getId() {
        return id;
    }

    public void setId(SensorId id) {
        this.id = id;
    }

    public Double getLastTemperature() {
        return lastTemperature;
    }

    public void setLastTemperature(Double lastTemperature) {
        this.lastTemperature = lastTemperature;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SensorMonitoring that = (SensorMonitoring) o;
        return Objects.equals(id, that.id) && Objects.equals(lastTemperature, that.lastTemperature) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastTemperature, updatedAt, enabled);
    }

    @Override
    public String toString() {
        return "SensorMonitoring{" +
                "sensorId=" + id +
                ", lastTemperature=" + lastTemperature +
                ", updatedAt=" + updatedAt +
                ", enabled=" + enabled +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private SensorId id;
        private Double lastTemperature;
        private OffsetDateTime updatedAt;
        private Boolean enabled;

        public Builder id(SensorId id) {
            this.id = id;
            return this;
        }

        public Builder lastTemperature(Double lastTemperature) {
            this.lastTemperature = lastTemperature;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder enabled(Boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public SensorMonitoring build() {
            return new SensorMonitoring(this.id, this.lastTemperature, this.updatedAt, this.enabled);
        }

        @Override
        public String toString() {
            return "SensorMonitoring.Builder{" +
                    "id=" + id +
                    ", lastTemperature=" + lastTemperature +
                    ", updatedAt=" + updatedAt +
                    ", enabled=" + enabled +
                    '}';
        }
    }
}
