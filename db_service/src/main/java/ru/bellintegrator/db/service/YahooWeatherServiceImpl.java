package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.db.dao.YahooWeatherDao;
import ru.bellintegrator.db.model.YahooWeather;
import ru.bellintegrator.db.model.mapper.MapperFacade;
import ru.bellintegrator.db.view.YahooWeatherView;


@Service
public class YahooWeatherServiceImpl implements YahooWeatherService{

    @Autowired
    private MapperFacade mapperFacade;

    private YahooWeatherDao yahooWeatherDao;

    public void setYahooWeatherDao(YahooWeatherDao yahooWeatherDao) {
        this.yahooWeatherDao = yahooWeatherDao;
    }

    @Transactional
    public void saveWeather(YahooWeatherView yahooWeatherView) {
        YahooWeather yahooWeather = mapperFacade.mapToModel(yahooWeatherView, new YahooWeather());
        yahooWeatherDao.save(yahooWeather);
    }
}
