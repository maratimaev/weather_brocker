package ru.bellintegrator.db.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "current_observation")
public class CurrentObservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_obs")
    private Integer idObs;

    @Version
    private Integer version;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wind_id", referencedColumnName = "id_wind")
    private Wind wind;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "atm_id", referencedColumnName = "id_atm")
    private Atmosphere atmosphere;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "astro_id", referencedColumnName = "id_astro")
    private Astronomy astronomy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "con_id", referencedColumnName = "id_con")
    private Condition condition;

    private Long pubDate;

    public Integer getIdObs() {
        return idObs;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Long getPubDate() {
        return pubDate;
    }

    public void setPubDate(Long pubDate) {
        this.pubDate = pubDate;
    }
}

