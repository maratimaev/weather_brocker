package ru.bellintegrator.common.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Отображение текущих температурных данных
 */
@JsonPropertyOrder({
        "text",
        "code",
        "temperature"
})
public class ConditionView implements Serializable {

    /**
     * Облачность
     */
    private String text;

    /**
     * Код
     */
    private Integer code;

    /**
     * Температура
     */
    private Integer temperature;

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

    @Override
    public String toString() {
        return "ConditionView{" +
                "text='" + text + '\'' +
                ", code=" + code +
                ", temperature=" + temperature +
                '}';
    }
}
