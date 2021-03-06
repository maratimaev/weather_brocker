package ru.bellintegrator.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.List;
import java.util.Objects;

/**
 * Модель метеоданных
 */
@Entity
@Table(name = "yahoo_weather")
public class YahooWeather {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Данные геолокации
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "loc_id")
    private Location location;

    /**
     * Текущая погода
     */
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "obs_id")
    private CurrentObservation currentObservation;

    /**
     * Прогноз погоды на 10 дней
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "for_id")
    private List<Forecast> forecastList;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    public Integer getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public CurrentObservation getCurrentObservation() {
        return currentObservation;
    }

    public void setCurrentObservation(CurrentObservation currentObservation) {
        this.currentObservation = currentObservation;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        if (this.forecastList == null) {
            this.forecastList = forecastList;
        } else {
            this.forecastList.clear();
            this.forecastList.addAll(forecastList);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YahooWeather that = (YahooWeather) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(currentObservation, that.currentObservation) &&
                Objects.equals(forecastList, that.forecastList);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
