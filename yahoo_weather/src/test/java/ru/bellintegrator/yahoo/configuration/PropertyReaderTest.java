package ru.bellintegrator.yahoo.configuration;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PropertyReaderTest {

    @Test
    public void whenReadUrlFromApplicationPropertiesThenGetHttpsString() {
        PropertyReader propertyReader = new PropertyReader();
        assertThat(propertyReader.getProperty("URL"), is("https://weather-ydn-yql.media.yahoo.com/forecastrss"));
    }

    @Test
    public void whenReadNonExistedPropertyThenCathException(){
        PropertyReader propertyReader = new PropertyReader();
        try {
            propertyReader.getProperty("NonExist");
        }catch (RuntimeException e){
            assertEquals(e.getMessage(), "Fail to read application.properties file ");
        }
    }
}