package ru.bellintegrator;

import ru.bellintegrator.view.YahooWeather;

import javax.annotation.Resource;
import javax.ejb.Stateless;

@Stateless
public class Service {
    @Resource(mappedName = "java:app/yahoo_weather/PollYahoo!ru.bellintegrator.PollYahoo")
    PollYahoo pollYahoo;

    @Resource(mappedName = "java:app/yahoo_weather/Deserialize!ru.bellintegrator.Deserialize")
    Deserialize deserialize;

    @Resource(mappedName = "java:app/yahoo_weather/JmsSender!ru.bellintegrator.JmsSender")
    JmsSender jmsSender;

    public void RequestWeather(String cityName) {
        String json = pollYahoo.get(cityName);
        YahooWeather yahooWeather = deserialize.map(json);
        jmsSender.sendMessage(yahooWeather);
    }
}
