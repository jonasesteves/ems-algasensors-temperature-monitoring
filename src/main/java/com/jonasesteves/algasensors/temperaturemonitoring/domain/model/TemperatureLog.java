package com.jonasesteves.algasensors.temperaturemonitoring.domain.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
public class TemperatureLog {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "UUID"))
    private TemperatureLogId id;

    @Column(name = "\"value\"")
    private Double value;

    private OffsetDateTime registeredAt;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "sensor_id", columnDefinition = "bigint"))
    private SensorId sensorId;

    public TemperatureLog() {
    }

    public TemperatureLog(TemperatureLogId id, Double value, OffsetDateTime registeredAt, SensorId sensorId) {
        this.id = id;
        this.value = value;
        this.registeredAt = registeredAt;
        this.sensorId = sensorId;
    }

    public TemperatureLogId getId() {
        return id;
    }

    public void setId(TemperatureLogId id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public OffsetDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(OffsetDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public SensorId getSensorId() {
        return sensorId;
    }

    public void setSensorId(SensorId sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureLog that = (TemperatureLog) o;
        return Objects.equals(id, that.id) && Objects.equals(value, that.value) && Objects.equals(registeredAt, that.registeredAt) && Objects.equals(sensorId, that.sensorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, registeredAt, sensorId);
    }

    @Override
    public String toString() {
        return "TemperatureLog{" +
                "id=" + id +
                ", value=" + value +
                ", registeredAt=" + registeredAt +
                ", sensorId=" + sensorId +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TemperatureLogId id;
        private Double value;
        private OffsetDateTime registeredAt;
        private SensorId sensorId;

        public Builder id(TemperatureLogId id) {
            this.id = id;
            return this;
        }

        public Builder value(Double value) {
            this.value = value;
            return this;
        }

        public Builder registeredAt(OffsetDateTime registeredAt) {
            this.registeredAt = registeredAt;
            return this;
        }

        public Builder sensorId(SensorId sensorId) {
            this.sensorId = sensorId;
            return this;
        }

        public TemperatureLog build() {
            return new TemperatureLog(this.id, this.value, this.registeredAt, this.sensorId);
        }

        @Override
        public String toString() {
            return "TemperatureLog.Builder{" +
                    "id=" + id +
                    ", value=" + value +
                    ", registeredAt=" + registeredAt +
                    ", sensorId=" + sensorId +
                    '}';
        }
    }
}
