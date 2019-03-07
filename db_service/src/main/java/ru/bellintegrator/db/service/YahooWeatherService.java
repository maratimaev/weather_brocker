package ru.bellintegrator.db.service;

import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.model.YahooWeather;

public interface YahooWeatherService {
    void saveWeather(YahooWeatherView yahooWeatherView);
    YahooWeather getYahooWeather(String city);
    YahooWeatherView getYahooWeatherView(String city);
}
