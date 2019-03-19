package ru.bellintegrator.yahoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class YahooPollerTest {

    @InjectMocks
    private YahooPoller yahooPoller;

    private final static String APP_ID="kYAIGJ64";
    private final static String CONSUMER_KEY="dj0yJmk9YUNnMjZIellNYTRXJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PWE3";
    private final static String CONSUMER_SECRET="23081a84d99662043bded37ead72a8b4ab919ae2";
    private final static String URL="https://weather-ydn-yql.media.yahoo.com/forecastrss";

    @Test
    public void whenPollYahooThenGetJsonString(){
        String responce = yahooPoller.getWeatherFromYahoo("Ufa");

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
        String response = yahooPoller.getWeatherFromYahoo("");
        assertThat(response, is("{\"location\":{},\"current_observation\":{},\"forecasts\":[]}"));
    }
}
