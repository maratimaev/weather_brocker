package ru.bellintegrator.yahoo.jms;

import ru.bellintegrator.common.view.YahooWeatherView;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class ToDbServiceSender {
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    JMSContext context;

    @Resource(mappedName = "java:/jms/queue/YahooWeatherToDbService")
    Queue queue;

    public void sendMessage(YahooWeatherView yahooWeatherView) {
        context.createProducer().send(queue, yahooWeatherView);
    }
}
