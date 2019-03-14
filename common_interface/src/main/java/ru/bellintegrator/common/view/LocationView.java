package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Отображение данных геолокации
 */
@JsonPropertyOrder({
        "woeid",
        "city",
        "region",
        "country",
        "lat",
        "long",
        "timezone_id"
})
public class LocationView implements Serializable {

    /**
     * Идентификатор
     */
    @JsonProperty("woeid")
    private Integer woeId;

    /**
     * Название города
     */
    private String city;

    /**
     * Название региона
     */
    private String region;

    /**
     * Название страны
     */
    private String country;

    /**
     * Широта
     */
    @JsonProperty("lat")
    private Float lattitude;

    /**
     * Долгота
     */
    @JsonProperty("long")
    private Float longitude;

    /**
     * Временная зона
     */
    @JsonProperty("timezone_id")
    private String timezoneId;

    public Integer getWoeId() {
        return woeId;
    }

    public void setWoeid(Integer woeId) {
        this.woeId = woeId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getLattitude() {
        return lattitude;
    }

    public void setLattitude(Float lattitude) {
        this.lattitude = lattitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    @Override
    public String toString() {
        return "LocationView{" +
                "woeid=" + woeId +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                ", timezoneId='" + timezoneId + '\'' +
                '}';
    }
}
