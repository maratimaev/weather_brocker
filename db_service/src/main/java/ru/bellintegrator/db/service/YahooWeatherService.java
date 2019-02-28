package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.db.dao.YahooWeatherDao;
import ru.bellintegrator.db.model.YahooWeather;
import ru.bellintegrator.db.model.mapper.MapperFacade;
import ru.bellintegrator.db.view.YahooWeatherView;


@Service
public class YahooWeatherService {

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private YahooWeatherDao yahooWeatherDao;

    @Transactional
    public void saveWeather(YahooWeatherView yahooWeatherView) {
        YahooWeather yahooWeather = mapperFacade.mapToModel(yahooWeatherView, new YahooWeather());
        yahooWeatherDao.save(yahooWeather);
    }
}
