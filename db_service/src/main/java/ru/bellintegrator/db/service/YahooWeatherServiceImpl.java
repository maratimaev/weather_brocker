package ru.bellintegrator.db.service;

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
    YahooWeatherRepository yahooWeatherRepository;

    /**
     * Методы для работы с географическими данными
     */
    @Autowired
    LocationRepository locationRepository;

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
    public YahooWeather getYahooWeather(String city) {
        Location location = locationRepository.findByCity(city);
        YahooWeather yahooWeather = yahooWeatherRepository.findByLocation(location);
        return yahooWeather;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public YahooWeatherView getYahooWeatherView(String city) {
        YahooWeather yahooWeather = getYahooWeather(city);
        return mapperFacade.map(yahooWeather, YahooWeatherView.class);
    }
}
