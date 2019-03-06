package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({
        "humidity",
        "visibility",
        "pressure",
        "rising"
})
public class AtmosphereView implements Serializable {

    private Integer humidity;

    private Integer visibility;

    private Float pressure;

    private Integer rising;

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Integer getRising() {
        return rising;
    }

    public void setRising(Integer rising) {
        this.rising = rising;
    }

    @Override
    public String toString() {
        return "AtmosphereView{" +
                "humidity=" + humidity +
                ", visibility=" + visibility +
                ", pressure=" + pressure +
                ", rising=" + rising +
                '}';
    }
}
