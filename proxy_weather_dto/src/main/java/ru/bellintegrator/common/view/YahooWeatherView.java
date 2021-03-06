package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.List;

/**
 * Отображение метеоданных
 */
@JsonPropertyOrder({
        "location",
        "current_observation",
        "forecasts"
})
public class YahooWeatherView implements Serializable {
    /**
     * Данные геолокации
     */
    @JsonProperty("location")
    private LocationView locationView;

    /**
     * Текущая погода
     */
    @JsonProperty("current_observation")
    private CurrentObservationView currentObservationView;

    /**
     * Прогноз погоды на 10 дней
     */
    @JsonProperty("forecasts")
    private List<ForecastsView> forecastsViewList;

    public LocationView getLocationView() {
        return locationView;
    }

    public void setLocationView(LocationView locationView) {
        this.locationView = locationView;
    }

    public CurrentObservationView getCurrentObservationView() {
        return currentObservationView;
    }

    public void setCurrentObservationView(CurrentObservationView currentObservationView) {
        this.currentObservationView = currentObservationView;
    }

    public List<ForecastsView> getForecastsViewList() {
        return forecastsViewList;
    }

    public void setForecastsViewList(List<ForecastsView> forecastsViewList) {
        this.forecastsViewList = forecastsViewList;
    }

    @Override
    public String toString() {
        return "YahooWeatherView{" +
                "locationView=" + locationView +
                ", currentObservationView=" + currentObservationView +
                ", forecastsViewList=" + forecastsViewList +
                '}';
    }
}
