/**
 * {@link ru.bellintegrator.yahoo.YahooPollerImpl} Запрос погодных данных с сайта yahoo.com
 * {@link ru.bellintegrator.yahoo.YahooWeatherDeserializer} Преобразование json в dto метеоданных
 * {@link ru.bellintegrator.yahoo.YahooWeatherService} Сервис запроса прогноза погоды с сайта yahoo
 *  и отправки dto в модуль базы данных db_service через EJB JMS queue
 */
package ru.bellintegrator.yahoo;