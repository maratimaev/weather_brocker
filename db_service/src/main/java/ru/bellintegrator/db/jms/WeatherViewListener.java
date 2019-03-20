package ru.bellintegrator.db.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.service.YahooWeatherService;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Чтение данных из модуля yahoo_weather по факту добавления сообщений в очередь
 * Название очереди указано в jndi сервера приложений WildFly
 * Инициализаци контекста Spring Framework через наследование SpringBeanAutowiringSupport
 */
@MessageDriven(
        mappedName="java:/jms/queue/YahooWeatherToDbService",
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "acknowledgeMode",
                        propertyValue = "auto-acknowledge"),
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(
                        propertyName = "destination",
                        propertyValue = "java:/jms/queue/YahooWeatherToDbService")
        })
public class WeatherViewListener extends SpringBeanAutowiringSupport implements MessageListener {

    /**
     * Сервис работы с БД для модели YahooWeather
     */
    @Autowired
    private YahooWeatherService yahooWeatherService;

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /** Получение сообщений из очереди
     * @param message dto прогноза погоды YahooWeatherView
     */
    @Override
    public void onMessage(Message message) {
        if(message == null){
            throw new RuntimeException("(Custom) Error -> recieved message == null");
        }

        try {
            YahooWeatherView yahooWeatherView = message.getBody(YahooWeatherView.class);
            yahooWeatherService.saveWeather(yahooWeatherView);
        } catch (JMSException e) {
            throw new RuntimeException("(Custom) Error message body incorrect", e);
        }
    }
}
