package ru.bellintegrator.db.service;

import ru.bellintegrator.common.view.YahooWeatherView;

/**
 * Сервисы для работы с метеоданными
 */
public interface YahooWeatherService {
    /** Запись данных  о погоде в БД
     * @param yahooWeatherView dto данных о погоде в конкретной местности
     */
    void saveWeather(YahooWeatherView yahooWeatherView);

    /** Возвращение dto метеоданных по названию города
     * @param city название города
     * @return dto метеоданных
     */
    YahooWeatherView getYahooWeatherView(String city);
}
