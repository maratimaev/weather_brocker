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
public class YahooWeatherListener extends SpringBeanAutowiringSupport implements MessageListener {

    @Autowired
    YahooWeatherService yahooWeatherService;

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void onMessage(Message message) {
        try {
            YahooWeatherView yahooWeatherView = message.getBody(YahooWeatherView.class);
            yahooWeatherService.saveWeather(yahooWeatherView);
        } catch (JMSException e) {
            throw new RuntimeException("(Custom) Error recieving message", e);
        }
    }
}
