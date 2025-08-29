package com.jonasesteves.algasensors.temperaturemonitoring.api.model;

import io.hypersistence.tsid.TSID;

import java.util.Objects;

public class SensorAlertOutput {
    private TSID id;
    private Double minTemperature;
    private Double maxTemperature;

    private SensorAlertOutput() {
    }

    public SensorAlertOutput(TSID id, Double minTemperature, Double maxTemperature) {
        this.id = id;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public TSID getId() {
        return id;
    }

    public void setId(TSID id) {
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
        SensorAlertOutput that = (SensorAlertOutput) o;
        return Objects.equals(id, that.id) && Objects.equals(minTemperature, that.minTemperature) && Objects.equals(maxTemperature, that.maxTemperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, minTemperature, maxTemperature);
    }

    @Override
    public String toString() {
        return "SensorAlertOutput{" +
                "id=" + id +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private TSID id;
        private Double minTemperature;
        private Double maxTemperature;

        public Builder id(TSID id) {
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

        public SensorAlertOutput build() {
            return new SensorAlertOutput(this.id, this.minTemperature, this.maxTemperature);
        }

        @Override
        public String toString() {
            return "SensorAlertOutput.Builder{" +
                    "id=" + id +
                    ", minTemperature=" + minTemperature +
                    ", maxTemperature=" + maxTemperature +
                    '}';
        }
    }

}
