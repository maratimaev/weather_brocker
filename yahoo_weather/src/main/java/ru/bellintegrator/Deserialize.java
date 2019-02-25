package ru.bellintegrator;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.bellintegrator.view.YahooWeather;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class Deserialize {
    public YahooWeather map(String weather) {
        YahooWeather yahooWeather = new YahooWeather();
        try {
            yahooWeather = new ObjectMapper().readerFor(YahooWeather.class).readValue(weather);
        } catch (IOException e) {
            throw new RuntimeException("Fail to deserialize YahooWeather", e);
        }
        return yahooWeather;
    }
}
