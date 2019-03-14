package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Модель данных геолокации
 */
@Entity
@Table(name = "location")
public class Location {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loc")
    private Integer idLoc;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    /**
     * Идентификатор
     */
    private Integer woeId;

    /**
     * Название города
     */
    @Column(length = 100)
    private String city;

    /**
     * Название региона
     */
    @Column(length = 100)
    private String region;

    /**
     * Название страны
     */
    @Column(length = 50)
    private String country;

    /**
     * Широта
     */
    private Float lattitude;

    /**
     * Долгота
     */
    private Float longitude;

    /**
     * Временная зона
     */
    @Column(name = "timezone_id")
    private String timezoneId;

    public Integer getIdLoc() {
        return idLoc;
    }

    public Integer getWoeId() {
        return woeId;
    }

    public void setWoeId(Integer woeId) {
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

}
