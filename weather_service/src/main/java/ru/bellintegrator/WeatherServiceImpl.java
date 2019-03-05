package ru.bellintegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.common.CommonWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private CommonWeatherService commonWeatherService;

    @Override
    public List<YahooWeatherView> list() {
        List<YahooWeatherView> yahooWeatherViewList = commonWeatherService.findAll();
        return yahooWeatherViewList;
    }
}
