package ru.bellintegrator;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
        mappedName="java:/jms/queue/TestQ",
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "acknowledgeMode",
                        propertyValue = "auto-acknowledge"),
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(
                        propertyName = "destination",
                        propertyValue = "java:/jms/queue/TestQ"),
        })

public class JmsListener implements MessageListener {

    @Resource(mappedName = "java:app/yahoo_weather/PollYahoo!ru.bellintegrator.PollYahoo")
    PollYahoo pollYahoo;

    @Override
    public void onMessage(Message message) {
        try {
            String msg = message.getBody(String.class);
            String str = pollYahoo.poll(msg);
            String str1 = "wfwf";
        } catch (JMSException e) {
            throw new RuntimeException("Error recieving message", e);
        }
    }
}
