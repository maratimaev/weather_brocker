package ru.bellintegrator.yahoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.yahoo.jms.ToDbServiceSender;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class YahooWeatherServiceTest {

    private String jsonWeather =
                    "{\"location\":" +
                    "{\"woeid\":2124045,\"city\":\"Ufa\",\"region\":\" Bashkortostan Republic\",\"country\":\"Russia\",\"lat\":54.749569,\"long\":56.05233,\"timezone_id\":\"Asia/Yekaterinburg\"" +
                    "}," +
                    "\"current_observation\":{" +
                    "\"wind\":{" +
                    "\"chill\":28,\"direction\":203,\"speed\":8.08" +
                    "}," +
                    "\"atmosphere\":" +
                    "{\"humidity\":69,\"visibility\":10.0,\"pressure\":29.59,\"rising\":0" +
                    "}," +
                    "\"astronomy\":" +
                    "{\"sunrise\":\"7:35 am\",\"sunset\":\"7:17 pm\"" +
                    "}," +
                    "\"condition\":" +
                    "{\"text\":\"Cloudy\",\"code\":26,\"temperature\":35" +
                    "}," +
                    "\"pubDate\":1552467600" +
                    "}," +
                    "\"forecasts\":[" +
                    "{\"day\":\"Wed\",\"date\":1552417200,\"low\":28,\"high\":36,\"text\":\"Cloudy\",\"code\":26}," +
                    "{\"day\":\"Thu\",\"date\":1552503600,\"low\":25,\"high\":33,\"text\":\"Cloudy\",\"code\":26}," +
                    "{\"day\":\"Fri\",\"date\":1552590000,\"low\":19,\"high\":30,\"text\":\"Partly Cloudy\",\"code\":30}," +
                    "{\"day\":\"Sat\",\"date\":1552676400,\"low\":14,\"high\":31,\"text\":\"Mostly Cloudy\",\"code\":28}," +
                    "{\"day\":\"Sun\",\"date\":1552762800,\"low\":23,\"high\":36,\"text\":\"Cloudy\",\"code\":26}," +
                    "{\"day\":\"Mon\",\"date\":1552849200,\"low\":23,\"high\":34,\"text\":\"Cloudy\",\"code\":26}," +
                    "{\"day\":\"Tue\",\"date\":1552935600,\"low\":29,\"high\":36,\"text\":\"Cloudy\",\"code\":26}," +
                    "{\"day\":\"Wed\",\"date\":1553022000,\"low\":29,\"high\":37,\"text\":\"Mostly Cloudy\",\"code\":28}," +
                    "{\"day\":\"Thu\",\"date\":1553108400,\"low\":31,\"high\":38,\"text\":\"Mostly Cloudy\",\"code\":28}," +
                    "{\"day\":\"Fri\",\"date\":1553194800,\"low\":28,\"high\":37,\"text\":\"Cloudy\",\"code\":26}" +
                    "]" +
                    "}";

    @Mock
    private YahooPoller yahooPoller;

    @Mock
    private YahooWeatherDeserializer yahooWeatherDeserializer;

    @Mock
    private ToDbServiceSender toDbServiceSender;

    @InjectMocks
    private YahooWeatherService yahooWeatherService;

    @Test
    public void whenGetCityNameThenPushYahooWeatherViewToQueue(){
        YahooWeatherView yahooWeatherView = mock(YahooWeatherView.class);
        when(yahooPoller.get("Ufa")).thenReturn(jsonWeather);
        when(yahooWeatherDeserializer.map(jsonWeather)).thenReturn(yahooWeatherView);

        yahooWeatherService.requestWeather("Ufa");

        verify(yahooPoller, atLeast(1)).get("Ufa");
        verify(yahooWeatherDeserializer, atLeast(1)).map(jsonWeather);
        verify(toDbServiceSender, atLeast(1)).sendMessage(yahooWeatherView);

    }
}