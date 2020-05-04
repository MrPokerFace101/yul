package ru.yul.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yul.models.Place;

import java.util.List;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query(nativeQuery = true, value = "select places from city where city.name = :city")
    List<Place> findByCity(@Param("city") String city);

    @Modifying
    @Query(nativeQuery = true, value = "update place set place.rating = :placeRating, place.ratesAmount = :ratesAmount where place.id = :placeId")
    int updatePlaceRating(@Param("placeRating") Double placeRating, @Param("ratesAmount") Long ratesAmount, @Param("placeId") Long placeId);
}
