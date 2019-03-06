package ru.bellintegrator.common;

import ru.bellintegrator.common.view.YahooWeatherView;

public interface ProxyWeatherService {
    YahooWeatherView getWeather(String city);
}
