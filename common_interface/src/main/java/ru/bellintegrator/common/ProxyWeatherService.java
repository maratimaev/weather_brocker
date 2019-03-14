package ru.bellintegrator.common;

/**
 * Оправка запроса погоды из модуля weather_service в db_service через hessian remote
 */
public interface ProxyWeatherService<T> {
    /** Запрос погоды
     * @param city название города, для которого запрашивается погода
     * @return объект view с погодными данными
     */
    T getWeather(String city);
}
