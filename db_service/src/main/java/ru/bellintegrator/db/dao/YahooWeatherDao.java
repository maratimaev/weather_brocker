package ru.bellintegrator.db.dao;

import ru.bellintegrator.db.model.YahooWeather;

import java.util.List;

public interface YahooWeatherDao {
    public void save(YahooWeather yahooWeather);
    public List<YahooWeather> findAll();
}
