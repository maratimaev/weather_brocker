package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({
        "sunrise",
        "sunset"
})
public class AstronomyView implements Serializable {

    private String sunrise;

    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "AstronomyView{" +
                "sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
