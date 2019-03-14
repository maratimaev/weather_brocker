package ru.bellintegrator.yahoo;

import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.yahoo.jms.ToDbServiceSender;

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
    YahooPoller yahooPoller;

    /**
     * Преобразование json в dto погодных данных
     */
    @Inject
    YahooWeatherDeserializer yahooWeatherDeserializer;

    /**
     * Отправка dto прогноза погодных данных в модуль db_service
     */
    @Inject
    ToDbServiceSender toDbServiceSender;

    /** Запрос прогноза погоды и отправка в модуль базы данных
     * @param cityName название города
     */
    public void requestWeather(String cityName) {
        String json = yahooPoller.get(cityName);
        YahooWeatherView yahooWeatherView = yahooWeatherDeserializer.map(json);
        toDbServiceSender.sendMessage(yahooWeatherView);
    }
}
