package ru.bellintegrator.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.db.model.Location;

/**
 * Методы для работы с географическими данными
 */
public interface LocationRepository extends JpaRepository<Location, Integer> {
    /** ППоиск геоданных по названию города
     * @param city название города
     * @return модель геоданных
     */
    Location findByCity(String city);
}
