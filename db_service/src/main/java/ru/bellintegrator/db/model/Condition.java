package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Модель текущих температурных данных
 */
@Entity
@Table(name = "condition")
public class Condition {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_con")
    private Integer idCon;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    /**
     * Облачность
     */
    @Column(length = 50)
    private String text;

    /**
     * Код
     */
    private Integer code;

    /**
     * Температура
     */
    private Integer temperature;

    public Integer getIdCon() {
        return idCon;
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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
}

