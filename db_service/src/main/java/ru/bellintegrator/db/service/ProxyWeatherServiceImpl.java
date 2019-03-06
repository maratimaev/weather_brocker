package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.dao.YahooWeatherDao;
import ru.bellintegrator.db.model.mapper.MapperFacade;

@Service
public class ProxyWeatherServiceImpl extends SpringBeanAutowiringSupport implements ProxyWeatherService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private YahooWeatherDao yahooWeatherDao;

    @Autowired
    private YahooWeatherService yahooWeatherService;

    @Override
    public YahooWeatherView getWeather(String city) {
//        List<YahooWeather> yahooWeatherList = yahooWeatherDao.findAll();
//        List<YahooWeatherView> yahooWeatherViewList = mapperFacade.mapAsList(yahooWeatherList, YahooWeatherView.class);
        YahooWeatherView yahooWeatherView = yahooWeatherService.getYahooWeather(city);
        return yahooWeatherView;
    }
}
