package ru.bellintegrator.yahoo;

/**
 * Запрос погодных данных с сайта yahoo.com
 */
public interface YahooPoller {
    /** Запрос прогноза по определенному городу
     * @param city название города, для которого запрашивается прогноз
     * @return json прогноза погоды
     */
    String getWeatherFromYahoo(String city);
}
