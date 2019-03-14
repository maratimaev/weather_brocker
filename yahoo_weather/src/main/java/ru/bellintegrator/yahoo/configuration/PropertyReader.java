package ru.bellintegrator.yahoo.configuration;

import javax.ejb.Stateless;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Чтение параметров из application.properties
 */
@Stateless
public class PropertyReader {
    /**
     * Параметры
     */
    private Properties property;
    /**
     * Файл с данными
     */
    private InputStream inputStream;

    public PropertyReader() {
        this.property = new Properties();
        this.inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
    }

    /** Чтение конкретного параметра
     * @param name запрашиваемый параметр
     * @return значение параметра
     */
    public String getProperty(String name) {
        try {
            this.property.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Fail to read application.properties file ", e);
        }
        return this.property.getProperty(name);
    }
}
