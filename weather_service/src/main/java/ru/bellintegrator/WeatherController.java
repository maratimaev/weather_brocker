package ru.bellintegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.bellintegrator.common.view.YahooWeatherView;

import java.util.List;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String viewHome(){
        List<YahooWeatherView> yahooWeatherViewList = weatherService.list();
        return "index";
    }
}
