package ru.bellintegrator.db.service;

import org.apache.commons.lang3.StringUtils;
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
        if(StringUtils.isEmpty(city)){
            throw new RuntimeException("(Custom) Error -> not found city name (== null)");
        }
        return yahooWeatherService.getYahooWeatherView(city);
    }
}
