package ru.bellintegrator.yahoo;

import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.yahoo.jms.ToDbServiceSender;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class YahooWeatherService {
    @Inject
    YahooPoller yahooPoller;

    @Inject
    YahooWeatherDeserializer yahooWeatherDeserializer;

    @Inject
    ToDbServiceSender toDbServiceSender;

    public void RequestWeather(String cityName) {
        String json = yahooPoller.get(cityName);
        YahooWeatherView yahooWeatherView = yahooWeatherDeserializer.map(json);
        toDbServiceSender.sendMessage(yahooWeatherView);
    }
}
