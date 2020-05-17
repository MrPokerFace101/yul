package ru.yul.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yul.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    City findByName(String name);

    @Query(nativeQuery = true, value = "select id from city where name = :name")
    Long findIdByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "insert into city_places (city_id, places_id) values (:cityId, :placeId)")
    void addPlaceToCityList(@Param("cityId") Long cityId, @Param("placeId") Long placeId);

    @Query(nativeQuery = true, value = "insert into city_routes (city_id, routes_id) values (:cityId, :routeId)")
    void addRouteToCityList(@Param("cityId") Long cityId, @Param("routeId") Long routeId);
}
