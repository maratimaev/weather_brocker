package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Отображение данных по ветру
 */
@JsonPropertyOrder({
        "chill",
        "direction",
        "speed"
})
public class WindView implements Serializable {

    /**
     * Температура ветра
     */
    private Integer chill;

    /**
     * Направление
     */
    private Integer direction;

    /**
     * Скорость
     */
    private Float speed;

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

    @Override
    public String toString() {
        return "WindView{" +
                "chill=" + chill +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}
