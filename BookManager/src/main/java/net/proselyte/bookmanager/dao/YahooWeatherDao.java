package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.YahooWeather;

import java.util.List;

public interface YahooWeatherDao {
    void save(YahooWeather yahooWeather);
    List<YahooWeather> findAll();
}
