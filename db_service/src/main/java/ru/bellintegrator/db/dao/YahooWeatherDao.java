package ru.bellintegrator.db.dao;

import ru.bellintegrator.db.model.YahooWeather;

public interface YahooWeatherDao {
    void save(YahooWeather yahooWeather);
    YahooWeather findWeather(String city);
}
