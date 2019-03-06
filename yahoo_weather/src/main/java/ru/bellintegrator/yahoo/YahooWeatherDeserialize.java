package ru.bellintegrator.yahoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.bellintegrator.common.view.YahooWeatherView;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class YahooWeatherDeserialize {

    public YahooWeatherView map(String weather) {
        YahooWeatherView yahooWeatherView;
        try {
            yahooWeatherView = new ObjectMapper().readerFor(YahooWeatherView.class).readValue(weather);
        } catch (IOException e) {
            throw new RuntimeException("Fail to deserialize YahooWeatherView", e);
        }
        return yahooWeatherView;
    }
}
