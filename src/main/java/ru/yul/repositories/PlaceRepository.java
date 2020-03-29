package ru.yul.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.Place;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query("select places from City where City.name = #{city}")
    List<Place> findByCity(String city);

    @Query("update Place set Place.rating = #{place.rating}, Place.ratesAmount = #{place.ratesAmount} where Place.id = #{place.id}")
    Place updatePlaceRating(Place place);
}
