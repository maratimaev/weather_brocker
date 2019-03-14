package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Модель рогноза погоды
 */
@Entity
@Table(name = "forecast")
public class Forecast {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_for")
    private Integer idFor;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    /**
     * День недели прогнозируемой погоды
     */
    @Column(length = 3)
    private String day;

    /**
     * Дата прогнозируемой погоды
     */
    private Long date;

    /**
     * Минимальный экстремум температуры
     */
    private Integer low;

    /**
     * Максимальный экстремум температуры
     */
    private Integer high;

    /**
     * Облачность
     */
    @Column(length = 50)
    private String text;

    /**
     * Код
     */
    private Integer code;

    public Integer getIdFor() {
        return idFor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

