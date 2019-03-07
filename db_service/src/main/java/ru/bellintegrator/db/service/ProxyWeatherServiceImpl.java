package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

@Service
public class ProxyWeatherServiceImpl extends SpringBeanAutowiringSupport implements ProxyWeatherService {

    @Autowired
    private YahooWeatherService yahooWeatherService;

    @Override
    public YahooWeatherView getWeather(String city) {
        return yahooWeatherService.getYahooWeatherView(city);
    }
}
