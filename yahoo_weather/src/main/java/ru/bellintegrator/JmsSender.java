package ru.bellintegrator;

import ru.bellintegrator.view.YahooWeather;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class JmsSender {
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    JMSContext context;

    @Resource(mappedName = "java:/jms/queue/YahooWeatherToDbService")
    Queue queue;

    public void sendMessage(YahooWeather weather) {
        context.createProducer().send(queue, weather);
    }
}
