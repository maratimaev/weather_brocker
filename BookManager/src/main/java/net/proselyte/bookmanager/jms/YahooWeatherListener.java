package net.proselyte.bookmanager.jms;

import net.proselyte.bookmanager.service.YahooWeatherService;
import net.proselyte.bookmanager.view.YahooWeatherView;
import net.proselyte.bookmanager.view.map.YahooWeatherViewDeserialize;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

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
@Component
public class YahooWeatherListener implements MessageListener {

//    @Autowired
    private YahooWeatherService yahooWeatherService;

//    @Autowired
    private YahooWeatherViewDeserialize yahooWeatherViewDeserialize;

    public void setYahooWeatherService(YahooWeatherService yahooWeatherService) {
        this.yahooWeatherService = yahooWeatherService;
    }

    public void setYahooWeatherViewDeserialize(YahooWeatherViewDeserialize yahooWeatherViewDeserialize) {
        this.yahooWeatherViewDeserialize = yahooWeatherViewDeserialize;
    }

        @PostConstruct
    public void init() throws Exception {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public void onMessage(Message message) {
        try {
            String weather = message.getBody(String.class);
            YahooWeatherView yahooWeatherView = yahooWeatherViewDeserialize.map(weather);
            yahooWeatherService.saveWeather(yahooWeatherView);
        } catch (JMSException e) {
            throw new RuntimeException("(Custom) Error recieving message", e);
        }
    }
}
