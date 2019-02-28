package ru.bellintegrator.yahoo.jms;

import ru.bellintegrator.yahoo.Service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

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

    @Inject
    Service service;

    @Override
    public void onMessage(Message message) {
        try {
            service.RequestWeather(message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException("Error recieving message", e);
        }
    }
}
