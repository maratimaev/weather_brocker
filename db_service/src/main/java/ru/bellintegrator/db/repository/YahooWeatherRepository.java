package ru.bellintegrator.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.db.model.Location;
import ru.bellintegrator.db.model.YahooWeather;

/**
 * Методы для работы с метеоданными
 */
public interface YahooWeatherRepository extends JpaRepository<YahooWeather,Integer> {
    /** Поиск данных о погоде в конкретной местности
     * @param location модель геоданных
     * @return модель данных о погоде
     */
    YahooWeather findByLocation(Location location);
}
