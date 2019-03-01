package net.proselyte.bookmanager.view.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.proselyte.bookmanager.view.YahooWeatherView;
import org.springframework.stereotype.Component;

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
