package ru.bellintegrator.common;

import ru.bellintegrator.common.view.YahooWeatherView;

import java.util.List;

public interface CommonWeatherService {
    public List<YahooWeatherView> findAll();
}
