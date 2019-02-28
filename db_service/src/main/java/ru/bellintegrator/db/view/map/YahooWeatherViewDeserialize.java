package ru.bellintegrator.db.view.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.bellintegrator.db.view.YahooWeatherView;

import java.io.IOException;

@Component
public class YahooWeatherViewDeserialize {
    public YahooWeatherView map(String weather) {
        YahooWeatherView yahooWeatherView = new YahooWeatherView();
        try {
            yahooWeatherView = new ObjectMapper().readerFor(YahooWeatherView.class).readValue(weather);
        } catch (IOException e) {
            throw new RuntimeException("Fail to deserialize YahooWeather", e);
        }
        return yahooWeatherView;
    }
}
