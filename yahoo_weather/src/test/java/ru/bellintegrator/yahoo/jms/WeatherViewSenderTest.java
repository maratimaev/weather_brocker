package ru.bellintegrator.yahoo.jms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bellintegrator.common.view.YahooWeatherView;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Queue;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WeatherViewSenderTest {

    @Mock
    JMSContext context;

    @Mock
    Queue queue;

    @InjectMocks
    WeatherViewSender weatherViewSender;

    @Before
    public void checkInjections(){
        Assert.assertNotNull(context);
        Assert.assertNotNull(queue);
        Assert.assertNotNull(weatherViewSender);
    }

    @Test
    public void whenSendMessageThenPushYahooWeatherViewToQueue(){
        YahooWeatherView yahooWeatherView = mock(YahooWeatherView.class);
        JMSProducer producer = mock(JMSProducer.class);
        when(context.createProducer()).thenReturn(producer);

        weatherViewSender.sendMessage(yahooWeatherView);

        verify(context, atLeast(1)).createProducer();
        verify(producer, atLeast(1)).send(queue, yahooWeatherView);
    }
}
