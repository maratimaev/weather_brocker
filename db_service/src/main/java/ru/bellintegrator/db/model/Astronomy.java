package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Модель астрономических данных
 */
@Entity
@Table(name = "astronomy")
public class Astronomy {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_astro")
    private Integer idAstro;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    /**
     * Время восхода
     */
    @Column(length = 15)
    private String sunrise;

    /**
     * Время заката
     */
    @Column(length = 15)
    private String sunset;

    public Integer getIdAstro() {
        return idAstro;
    }

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
}

