package ru.bellintegrator.db.view;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties({"current_observation", "forecasts"})
public class YahooWeatherView implements Serializable {
    @JsonProperty("location")
    private LocationView locationView;

//    @JsonProperty("current_observation")
//    private List<String> currentObservation;
//
//    @JsonProperty("forecasts")
//    private List<String> forecasts;


    public LocationView getLocationView() {
        return locationView;
    }

    public void setLocationView(LocationView locationView) {
        this.locationView = locationView;
    }

    @Override
    public String toString() {
        return "YahooWeatherView{" +
                "locationView=" + locationView +
                '}';
    }
}
