package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "wind")
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wind")
    private Integer idWind;

    @Version
    private Integer version;

    private Integer chill;

    private Integer direction;

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
