package ru.bellintegrator.yahoo.jms;

import ru.bellintegrator.yahoo.YahooWeatherService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Чтение данных из модуля admin_api по факту добавления сообщений в очередь
 * Название очереди указано в jndi сервера приложений WildFly
 */
@MessageDriven(
        mappedName="java:/jms/queue/AdminApiToYahooWeather",
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "acknowledgeMode",
                        propertyValue = "auto-acknowledge"),
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(
                        propertyName = "destination",
                        propertyValue = "java:/jms/queue/AdminApiToYahooWeather"),
        })
public class AdminApiListener implements MessageListener {

    /**
     * Сервис обработки погодных данных
     */
    @Inject
    private YahooWeatherService yahooWeatherService;

    /** Получение сообщений из очереди
     * @param message название города
     */
    @Override
    public void onMessage(Message message) {
        try {
            if(message.isBodyAssignableTo(String.class)) {
                yahooWeatherService.requestWeather(message.getBody(String.class));
            }else {
                throw new RuntimeException("Incorrect message body type, must be String ");
            }
        } catch (JMSException e) {
            throw new RuntimeException("Error receiving String message ", e);
        }
    }
}
