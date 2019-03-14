package ru.bellintegrator.db.service;

import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.model.YahooWeather;

/**
 * Сервисы для работы с метеоданными
 */
public interface YahooWeatherService {
    /** Запись данных  о погоде в БД
     * @param yahooWeatherView dto данных о погоде в конкретной местности
     */
    void saveWeather(YahooWeatherView yahooWeatherView);

    /** Чтение метеоданных из БД по названию города
     * @param city название города
     * @return модель метеоданных
     */
    YahooWeather getYahooWeather(String city);

    /** Возвращение dto метеоданных по названию города
     * @param city название города
     * @return dto метеоданных
     */
    YahooWeatherView getYahooWeatherView(String city);
}
