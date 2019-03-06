package ru.bellintegrator;

import ru.bellintegrator.common.view.YahooWeatherView;

public interface GetWeatherService {
    YahooWeatherView get(String city);
}
