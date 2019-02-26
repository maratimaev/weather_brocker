package ru.bellintegrator.yahoo.view.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.bellintegrator.yahoo.view.YahooWeatherView;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class YahooWeatherDeserialize {
    public YahooWeatherView map(String weather) {
        YahooWeatherView yahooWeatherView = new YahooWeatherView();
        try {
            yahooWeatherView = new ObjectMapper().readerFor(YahooWeatherView.class).readValue(weather);
        } catch (IOException e) {
            throw new RuntimeException("Fail to deserialize YahooWeatherView", e);
        }
        return yahooWeatherView;
    }

    public String unMap(YahooWeatherView yahooWeatherView) {
        String weather = "";
        try {
            weather = new ObjectMapper().writeValueAsString(yahooWeatherView);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Fail to serialize YahooWeatherView", e);
        }
        return weather;
    }
}
