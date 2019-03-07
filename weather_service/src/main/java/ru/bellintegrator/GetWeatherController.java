package ru.bellintegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.common.ProxyWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;

@RestController
public class GetWeatherController {

    @Autowired
    private ProxyWeatherService proxyWeatherService;

    @GetMapping(value = "/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public YahooWeatherView organizationById(@PathVariable String city) {
        return proxyWeatherService.getWeather(city);
    }
}
