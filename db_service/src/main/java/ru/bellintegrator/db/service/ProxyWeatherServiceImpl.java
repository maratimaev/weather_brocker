package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

/**
 * {@inheritDoc}
 */
@Service
public class ProxyWeatherServiceImpl extends SpringBeanAutowiringSupport implements ProxyWeatherService<YahooWeatherView> {

    /**
     * Сервисы для работы с метеоданными
     */
    @Autowired
    private YahooWeatherService yahooWeatherService;

    /**
     * {@inheritDoc}
     */
    @Override
    public YahooWeatherView getWeather(String city) {
        return yahooWeatherService.getYahooWeatherView(city);
    }
}
