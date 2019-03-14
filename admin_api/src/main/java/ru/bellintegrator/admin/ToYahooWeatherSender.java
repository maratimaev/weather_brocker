package ru.bellintegrator.admin;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Класс отправляющий название города в модуль yahoo_weather
 * Название очереди указано в jndi сервера приложений WildFly
 */
@Stateless
public class ToYahooWeatherSender {
    /**
     * Контекст службы каталогов
     */
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    JMSContext context;

    /**
     * Очередь для отправки сообщений
     */
    @Resource(mappedName = "java:/jms/queue/AdminApiToYahooWeather")
    Queue queue;

    /** Отправка данных в очередь
     * @param message название города
     */
    public void sendMessage(String message) {
            context.createProducer().send(queue, message);
    }
}
