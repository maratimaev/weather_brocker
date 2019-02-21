package ru.bellintegrator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YahooWeather {
    @JsonProperty("location")
    private Location location;
}
