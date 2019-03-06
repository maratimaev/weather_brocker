package ru.bellintegrator.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "atmosphere")
public class Atmosphere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atm")
    private Integer idAtm;

    @Version
    private Integer version;

    private Integer humidity;

    private Integer visibility;

    private Float pressure;

    private Integer rising;

    public Integer getIdAtm() {
        return idAtm;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Float getPressure() {
        return pressure;
    }

    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public Integer getRising() {
        return rising;
    }

    public void setRising(Integer rising) {
        this.rising = rising;
    }
}

