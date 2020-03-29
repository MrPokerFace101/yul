package ru.yul.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    City findByName(String name);
}
