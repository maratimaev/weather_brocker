package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({
        "wind",
        "atmosphere",
        "astronomy",
        "condition",
        "pubDate"
})
public class CurrentObservationView implements Serializable {

    @JsonProperty("wind")
    private WindView windView;

    @JsonProperty("atmosphere")
    private AtmosphereView atmosphereView;

    @JsonProperty("astronomy")
    private AstronomyView astronomyView;

    @JsonProperty("condition")
    private ConditionView conditionView;

    private Long pubDate;

    public WindView getWindView() {
        return windView;
    }

    public void setWindView(WindView windView) {
        this.windView = windView;
    }

    public AtmosphereView getAtmosphereView() {
        return atmosphereView;
    }

    public void setAtmosphereView(AtmosphereView atmosphereView) {
        this.atmosphereView = atmosphereView;
    }

    public AstronomyView getAstronomyView() {
        return astronomyView;
    }

    public void setAstronomyView(AstronomyView astronomyView) {
        this.astronomyView = astronomyView;
    }

    public ConditionView getConditionView() {
        return conditionView;
    }

    public void setConditionView(ConditionView conditionView) {
        this.conditionView = conditionView;
    }

    public Long getPubDate() {
        return pubDate;
    }

    public void setPubDate(Long pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "CurrentObservationView{" +
                "wind=" + windView +
                ", atmosphere=" + atmosphereView +
                ", astronomy=" + astronomyView +
                ", condition=" + conditionView +
                ", pubDate=" + pubDate +
                '}';
    }
}
