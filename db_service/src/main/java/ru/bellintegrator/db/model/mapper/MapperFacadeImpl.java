package ru.bellintegrator.db.model.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;
import ru.bellintegrator.common.view.CurrentObservationView;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.model.CurrentObservation;
import ru.bellintegrator.db.model.YahooWeather;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Component
public class MapperFacadeImpl implements MapperFacade {

    private MapperFactory mapperFactory;

    @PostConstruct
    private void init(){
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> D map(S sourceObject, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().map(sourceObject, destinationClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, D> List<D> mapAsList(Iterable<S> source, Class<D> destinationClass) {
        return mapperFactory.getMapperFacade().mapAsList(source, destinationClass);
    }

    public YahooWeather mapToModel(YahooWeatherView yahooWeatherView, YahooWeather yahooWeather) {
        mapperFactory.classMap(YahooWeatherView.class, YahooWeather.class)
                .field("locationView", "location")
                .field("currentObservationView", "currentObservation")
                .field("forecastsViewList", "forecastList")
                .register();
        mapperFactory.classMap(CurrentObservationView.class, CurrentObservation.class)
                .field("windView", "wind")
                .field("atmosphereView", "atmosphere")
                .field("astronomyView", "astronomy")
                .field("conditionView", "condition")
                .field("pubDate", "pubDate")
                .register();
        mapperFactory.getMapperFacade(YahooWeatherView.class, YahooWeather.class).map(yahooWeatherView, yahooWeather);
        return yahooWeather;
    }

}
