package ru.bellintegrator;

import ru.bellintegrator.common.view.YahooWeatherView;

import java.util.List;

public interface WeatherService {
    public List<YahooWeatherView> list();
}
