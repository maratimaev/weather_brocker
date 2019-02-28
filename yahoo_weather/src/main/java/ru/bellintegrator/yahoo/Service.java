package ru.bellintegrator.yahoo;

import ru.bellintegrator.yahoo.jms.DbServiceSender;
import ru.bellintegrator.yahoo.view.YahooWeatherView;
import ru.bellintegrator.yahoo.view.map.YahooWeatherDeserialize;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Service {
    @Inject
    PollYahoo pollYahoo;

    @Inject
    YahooWeatherDeserialize yahooWeatherDeserialize;

    @Inject
    DbServiceSender dbServiceSender;

    public void RequestWeather(String cityName) {
        String json = pollYahoo.get(cityName);
        YahooWeatherView yahooWeatherView = yahooWeatherDeserialize.map(json);
        String weather = yahooWeatherDeserialize.unMap(yahooWeatherView);
        dbServiceSender.sendMessage(weather);
    }
}
