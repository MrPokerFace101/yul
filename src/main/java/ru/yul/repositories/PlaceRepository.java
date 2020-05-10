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

    @Query(nativeQuery = true,
            value = "select p.id, p.description, p.name, p.rates_amount, p.rating, p.x, p.y from city join city_places on city.id = city_places.city_id " +
                    "join place p on city_places.places_id = p.id where city.name = :city")
    List<Place> findByCity(@Param("city") String city);

    @Modifying
    @Query(nativeQuery = true, value = "update place set place.rating = :placeRating, place.rates_amount = :ratesAmount where place.id = :placeId")
    int updatePlaceRating(@Param("placeRating") Double placeRating, @Param("ratesAmount") Long ratesAmount, @Param("placeId") Long placeId);

    Place findByXAndY(Double x, Double y);
}
