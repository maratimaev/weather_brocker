package ru.bellintegrator.yahoo.configuration;

import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Stateless
public class PropertyReader {
    private Properties property;
    private InputStream inputStream;

    public PropertyReader() {
        this.property = new Properties();
        this.inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
    }

    public String getProperty(String name) {
        try {
            this.property.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Fail to read application.properties file", e);
        }
        return this.property.getProperty(name);
    }
}
