package ru.bellintegrator.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bellintegrator.db.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Location findByCity(String city);
}
