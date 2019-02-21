package ru.bellintegrator;


import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class SetWeatherLocation {
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    JMSContext context;

    @Resource(mappedName = "java:/jms/queue/TestQ")
    Queue queue;

    public void sendMessage(String message) {
            context.createProducer().send(queue, message);
    }
}
