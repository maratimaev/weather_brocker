package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Отображение прогноза погоды
 */
@JsonPropertyOrder({
        "day",
        "date",
        "low",
        "high",
        "text",
        "code"
})
public class ForecastsView implements Serializable {
    /**
     * День недели прогнозируемой погоды
     */
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
    private String text;

    /**
     * Код
     */
    private Integer code;

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

    @Override
    public String toString() {
        return "ForecastsView{" +
                "day='" + day + '\'' +
                ", date=" + date +
                ", low=" + low +
                ", high=" + high +
                ", text='" + text + '\'' +
                ", code=" + code +
                '}';
    }
}
