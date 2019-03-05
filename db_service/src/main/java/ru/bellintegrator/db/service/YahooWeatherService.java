package ru.bellintegrator.db.service;

import ru.bellintegrator.db.view.YahooWeatherView;

import java.util.List;

public interface YahooWeatherService {
    public void saveWeather(YahooWeatherView yahooWeatherView);
    public List<YahooWeatherView> findAll();
}
