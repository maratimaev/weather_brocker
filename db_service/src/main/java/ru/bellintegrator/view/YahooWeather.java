package ru.bellintegrator.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties({"current_observation", "forecasts"})
public class YahooWeather implements Serializable {
    @JsonProperty("location")
    private Location location;

    @JsonProperty("current_observation")
    private List<String> currentObservation;

    @JsonProperty("forecasts")
    private List<String> forecasts;
}
