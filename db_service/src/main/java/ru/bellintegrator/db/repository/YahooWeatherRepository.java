package ru.bellintegrator.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.db.model.Location;
import ru.bellintegrator.db.model.YahooWeather;

public interface YahooWeatherRepository extends JpaRepository<YahooWeather,Integer> {
    YahooWeather findByLocation(Location location);
}
