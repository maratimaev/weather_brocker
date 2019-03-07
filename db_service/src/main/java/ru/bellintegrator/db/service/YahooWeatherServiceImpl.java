package ru.bellintegrator.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.dao.YahooWeatherDao;
import ru.bellintegrator.db.model.YahooWeather;
import ru.bellintegrator.db.model.mapper.MapperFacade;

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
        YahooWeather yahooWeather = getYahooWeather(yahooWeatherView.getLocationView().getCity());
        if (yahooWeather == null) {
            yahooWeather = new YahooWeather();
        }
        mapperFacade.mapToModel(yahooWeatherView, yahooWeather);
        yahooWeatherDao.save(yahooWeather);
    }

    @Override
    @Transactional(readOnly = true)
    public YahooWeather getYahooWeather(String city) {
        return yahooWeatherDao.findWeather(city);
    }

    @Override
    @Transactional(readOnly = true)
    public YahooWeatherView getYahooWeatherView(String city) {
        YahooWeather yahooWeather = getYahooWeather(city);
        return mapperFacade.map(yahooWeather, YahooWeatherView.class);
    }
}
