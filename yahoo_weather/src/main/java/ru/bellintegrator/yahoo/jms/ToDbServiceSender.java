package ru.bellintegrator.yahoo.jms;

import ru.bellintegrator.common.view.YahooWeatherView;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * Отправка dto прогноза погодных данных в модуль db_service
 * Название очереди указано в jndi сервера приложений WildFly
 */
@Stateless
public class ToDbServiceSender {
    /**
     * Контекст службы каталогов
     */
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    JMSContext context;

    /**
     * Очередь сообщений
     */
    @Resource(mappedName = "java:/jms/queue/YahooWeatherToDbService")
    Queue queue;

    /** Отправка данных в очередь
     * @param yahooWeatherView dto прогноза погодных данных
     */
    public void sendMessage(YahooWeatherView yahooWeatherView) {
        context.createProducer().send(queue, yahooWeatherView);
    }
}
