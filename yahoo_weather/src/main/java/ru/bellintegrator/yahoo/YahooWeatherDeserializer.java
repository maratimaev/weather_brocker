package ru.bellintegrator.yahoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.bellintegrator.common.view.YahooWeatherView;

import javax.ejb.Stateless;
import java.io.IOException;

/**
 * Преобразование json в dto погодных данных
 */
@Stateless
public class YahooWeatherDeserializer {
    /** Десереализация json
     * @param weather json прогноза погоды определенного города
     * @return dto погодных данных
     */
    public YahooWeatherView map(String weather) {
        if(weather == null || weather.isEmpty()){
            throw new RuntimeException("(Custom) Error -> json weather == null");
        }
        try {
            return new ObjectMapper().readerFor(YahooWeatherView.class).readValue(weather);
        } catch (IOException e) {
            throw new RuntimeException("Fail to deserialize YahooWeatherView ", e);
        }
    }
}
