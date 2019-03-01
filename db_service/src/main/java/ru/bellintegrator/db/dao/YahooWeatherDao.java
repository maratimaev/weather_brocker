package ru.bellintegrator.db.dao;

import ru.bellintegrator.db.model.YahooWeather;

import java.util.List;

public interface YahooWeatherDao {
    void save(YahooWeather yahooWeather);
    List<YahooWeather> findAll();
}
