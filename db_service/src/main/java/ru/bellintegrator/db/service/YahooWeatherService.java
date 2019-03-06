package ru.bellintegrator.db.service;

import ru.bellintegrator.common.view.YahooWeatherView;

public interface YahooWeatherService {
    public void saveWeather(YahooWeatherView yahooWeatherView);
    YahooWeatherView getYahooWeather(String city);
}
