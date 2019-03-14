package ru.bellintegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

/**
 * Получение данных для запроса погоды
 */
@RestController
public class GetWeatherController {

    /**
     * Сервис получения данных из модуля db_service через hessian remote
     */
    @Autowired
    private ProxyWeatherService<YahooWeatherView> proxyWeatherService;

    /** Контроллер обработки запросов по названию города
     * @param city название города
     * @return json прогноза погоды
     */
    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public YahooWeatherView organizationById(@PathVariable String city) {
        return proxyWeatherService.getWeather(city);
    }
}
