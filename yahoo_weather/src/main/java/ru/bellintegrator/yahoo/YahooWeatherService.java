package ru.bellintegrator.yahoo;

import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.yahoo.jms.WeatherViewSender;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Сервис обработки погодных данных
 */
@Stateless
public class YahooWeatherService {
    /**
     * Запрос погодных данных с сайта yahoo.com
     */
    @Inject
    private YahooPoller yahooPoller;

    /**
     * Преобразование json в dto погодных данных
     */
    @Inject
    private YahooWeatherDeserializer yahooWeatherDeserializer;

    /**
     * Отправка dto прогноза погодных данных в модуль db_service
     */
    @Inject
    private WeatherViewSender weatherViewSender;

    /** Запрос прогноза погоды и отправка в модуль базы данных
     * @param cityName название города
     */
    public void requestWeather(String cityName) {
        if(cityName == null || cityName.isEmpty()){
            throw new RuntimeException("(Custom) Error -> can't proceed polling yahoo.com, city name == null");
        }
        String json = yahooPoller.getWeatherFromYahoo(cityName);
        YahooWeatherView yahooWeatherView = yahooWeatherDeserializer.map(json);
        weatherViewSender.sendMessage(yahooWeatherView);
    }
}
