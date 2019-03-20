package ru.bellintegrator.db.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.model.Location;
import ru.bellintegrator.db.model.YahooWeather;
import ru.bellintegrator.db.model.mapper.MapperFacade;
import ru.bellintegrator.db.repository.LocationRepository;
import ru.bellintegrator.db.repository.YahooWeatherRepository;

/**
 * {@inheritDoc}
 */
@Service
public class YahooWeatherServiceImpl implements YahooWeatherService{
    /**
     * Методы для работы с метеоданными
     */
    @Autowired
    private YahooWeatherRepository yahooWeatherRepository;
    /**
     * Методы для работы с географическими данными
     */
    @Autowired
    private LocationRepository locationRepository;
    /**
     * Фасад для преобразования между моделями БД и фронта
     */
    @Autowired
    private MapperFacade mapperFacade;

    /**
     * {@inheritDoc}
     */
    @Transactional
    public void saveWeather(YahooWeatherView yahooWeatherView) {
        if(yahooWeatherView == null){
            throw new RuntimeException("(Custom) Error -> can't save null dto yahooWeatherView");
        }
        YahooWeather yahooWeather = getYahooWeather(yahooWeatherView.getLocationView().getCity());
        if (yahooWeather == null) {
            yahooWeather = new YahooWeather();
        }
        mapperFacade.mapToModel(yahooWeatherView, yahooWeather);
        yahooWeatherRepository.saveAndFlush(yahooWeather);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public YahooWeatherView getYahooWeatherView(String city) {
        YahooWeatherView yahooWeatherView;
        if(StringUtils.isEmpty(city)){
            yahooWeatherView = new YahooWeatherView();
        } else {
            YahooWeather yahooWeather = getYahooWeather(city);
            yahooWeatherView = mapperFacade.map(yahooWeather, YahooWeatherView.class);
        }
        return yahooWeatherView;
    }

    private YahooWeather getYahooWeather(String city) {
        YahooWeather yahooWeather;
        if(StringUtils.isEmpty(city)){
            yahooWeather = new YahooWeather();
        } else {
            Location location = locationRepository.findByCity(city);
            yahooWeather = yahooWeatherRepository.findByLocation(location);
        }
        return yahooWeather;
    }
}
