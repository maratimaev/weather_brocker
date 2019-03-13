package ru.bellintegrator.yahoo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bellintegrator.common.view.YahooWeatherView;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class YahooWeatherDeserializerTest {

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


    @Test
    public void whenDeserializeJsonThenGetYahooWeatherView(){
        YahooWeatherDeserializer yahooWeatherDeserializer = new YahooWeatherDeserializer();
        YahooWeatherView yahooWeatherView = mock(YahooWeatherView.class);

        assertThat(yahooWeatherDeserializer.map(jsonWeather).getClass().getSimpleName(), is("YahooWeatherView"));
    }

    @Test
    public void whenDeserializeWrongJsonThenCathException(){
        YahooWeatherDeserializer yahooWeatherDeserializer = new YahooWeatherDeserializer();
        try {
            yahooWeatherDeserializer.map("");
        }catch (RuntimeException e){
            assertEquals(e.getMessage(), "Fail to deserialize YahooWeatherView ");
        }
    }
}