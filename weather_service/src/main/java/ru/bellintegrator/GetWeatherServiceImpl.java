package ru.bellintegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

@Service
public class GetWeatherServiceImpl implements GetWeatherService {

    @Autowired
    private ProxyWeatherService proxyWeatherService;

    @Override
    public YahooWeatherView get(String city) {
        YahooWeatherView yahooWeatherViewList = proxyWeatherService.getWeather(city);
        return yahooWeatherViewList;
    }
}
