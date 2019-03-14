package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Модель данных по ветру
 */
@Entity
@Table(name = "wind")
public class Wind {
    /**
     * Первичный ключ
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wind")
    private Integer idWind;

    /**
     * Служебное поле JPA
     */
    @Version
    private Integer version;

    /**
     * Температура ветра
     */
    private Integer chill;

    /**
     * Направление ветра
     */
    private Integer direction;

    /**
     * Скорость ветра
     */
    private Float speed;

    public Integer getIdWind() {
        return idWind;
    }

    public Integer getChill() {
        return chill;
    }

    public void setChill(Integer chill) {
        this.chill = chill;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }
}
