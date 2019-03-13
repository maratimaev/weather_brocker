package ru.bellintegrator.yahoo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bellintegrator.yahoo.configuration.PropertyReader;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class YahooPollerTest {

    @Mock
    private PropertyReader propertyReader;

    @InjectMocks
    private YahooPoller yahooPoller;

    @Before
    public void initProperties(){
        when(propertyReader.getProperty("APP_ID")).thenReturn("kYAIGJ64");
        when(propertyReader.getProperty("CONSUMER_KEY")).thenReturn("dj0yJmk9YUNnMjZIellNYTRXJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PWE3");
        when(propertyReader.getProperty("CONSUMER_SECRET")).thenReturn("23081a84d99662043bded37ead72a8b4ab919ae2");
        when(propertyReader.getProperty("URL")).thenReturn("https://weather-ydn-yql.media.yahoo.com/forecastrss");
    }

    @Test
    public void whenPollYahooThenGetJsonString(){
        String responce = yahooPoller.get("Ufa");

        assertThat(responce.contains("location"), is(true));
        assertThat(responce.contains("wind"), is(true));
        assertThat(responce.contains("current_observation"), is(true));
        assertThat(responce.contains("forecast"), is(true));
        assertThat(responce.contains("atmosphere"), is(true));
        assertThat(responce.contains("astronomy"), is(true));
        assertThat(responce.contains("condition"), is(true));
    }

    @Test
    public void ignoreEmptyString(){
        String response = yahooPoller.get("");
        assertThat(response, is("{\"location\":{},\"current_observation\":{},\"forecasts\":[]}"));
    }
}
