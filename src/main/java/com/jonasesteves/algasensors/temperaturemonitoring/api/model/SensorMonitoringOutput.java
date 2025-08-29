package com.jonasesteves.algasensors.temperaturemonitoring.api.model;

import io.hypersistence.tsid.TSID;

import java.time.OffsetDateTime;
import java.util.Objects;

public class SensorMonitoringOutput {

    private TSID id;
    private Double lastTemperature;
    private OffsetDateTime updatedAt;
    private Boolean enabled;

    private SensorMonitoringOutput() {
    }

    private SensorMonitoringOutput(TSID id, Double lastTemperature, OffsetDateTime updatedAt, Boolean enabled) {
        this.id = id;
        this.lastTemperature = lastTemperature;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
    }

    public TSID getId() {
        return id;
    }

    public void setId(TSID id) {
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
        SensorMonitoringOutput that = (SensorMonitoringOutput) o;
        return Objects.equals(id, that.id) && Objects.equals(lastTemperature, that.lastTemperature) && Objects.equals(updatedAt, that.updatedAt) && Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastTemperature, updatedAt, enabled);
    }

    @Override
    public String toString() {
        return "SensorMonitoringOutput{" +
                "id=" + id +
                ", lastTemperature=" + lastTemperature +
                ", updatedAt=" + updatedAt +
                ", enabled=" + enabled +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TSID id;
        private Double lastTemperature;
        private OffsetDateTime updatedAt;
        private Boolean enabled;

        public Builder id(TSID id) {
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

        public SensorMonitoringOutput build() {
            return new SensorMonitoringOutput(this.id, this.lastTemperature, this.updatedAt, this.enabled);
        }

        @Override
        public String toString() {
            return "SensorMonitoringOutput.Builder{" +
                    "id=" + id +
                    ", lastTemperature=" + lastTemperature +
                    ", updatedAt=" + updatedAt +
                    ", enabled=" + enabled +
                    '}';
        }
    }
}
