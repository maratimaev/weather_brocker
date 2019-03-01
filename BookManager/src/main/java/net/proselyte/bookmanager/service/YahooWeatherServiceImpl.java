package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.YahooWeatherDao;
import net.proselyte.bookmanager.model.YahooWeather;
import net.proselyte.bookmanager.model.mapper.MapperFacade;
import net.proselyte.bookmanager.view.YahooWeatherView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class YahooWeatherServiceImpl implements YahooWeatherService {
    @Autowired
    private MapperFacade mapperFacade;

//    @Autowired
    private YahooWeatherDao yahooWeatherDao;

    public void setYahooWeatherDao(YahooWeatherDao yahooWeatherDao) {
        this.yahooWeatherDao = yahooWeatherDao;
    }

    @Transactional
    public void saveWeather(YahooWeatherView yahooWeatherView) {
        YahooWeather yahooWeather = mapperFacade.mapToModel(yahooWeatherView, new YahooWeather());
        yahooWeatherDao.save(yahooWeather);
    }

    public void hessianServer(){

    }
}
