package ru.bellintegrator.yahoo.jms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bellintegrator.yahoo.YahooWeatherService;

import javax.jms.JMSException;
import javax.jms.Message;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityNameListenerTest {
    @Mock
    private YahooWeatherService yahooWeatherService;

    @InjectMocks
    private CityNameListener cityNameListener;

    @Before
    public void checkInjections(){
        Assert.assertNotNull(yahooWeatherService);
        Assert.assertNotNull(cityNameListener);
    }

    @Test
    public void whenReceiveMessageThenCallRequestWeather() throws JMSException {
        Message message = mock(Message.class);
        String location = "Ufa";
        when(message.isBodyAssignableTo(String.class)).thenReturn(true);
        when(message.getBody(String.class)).thenReturn(location);

        cityNameListener.onMessage(message);
        verify(yahooWeatherService, atLeast(1)).requestWeather(location);
    }

    @Test
    public void whenReceiveWrongBodyMessageThenCatchException() throws JMSException {
        Message message = mock(Message.class);
        when(message.isBodyAssignableTo(String.class)).thenReturn(false);

        try {
            cityNameListener.onMessage(message);
        }catch (RuntimeException e){
            assertEquals(e.getMessage(), "Incorrect message body type, must be String ");
        }
    }
}
