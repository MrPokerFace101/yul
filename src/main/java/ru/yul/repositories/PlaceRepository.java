package ru.yul.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yul.dto.XYPlaceDto;
import ru.yul.models.Place;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Query("select p from City c join c.places p where c.name = :city")
    List<Place> findByCity(@Param("city") String city);

    @Query("select new ru.yul.dto.XYPlaceDto(p.x, p.y) from City c join c.places p where c.name = :city")
    List<XYPlaceDto> findPlacesCoordinatesByCity(@Param("city") String city);

    @Modifying
    @Query("update Place p set p.rating = :placeRating, p.ratesAmount = :ratesAmount where p.id = :placeId")
    int updatePlaceRating(@Param("placeRating") Double placeRating, @Param("ratesAmount") Long ratesAmount,
                          @Param("placeId") Long placeId);

    Optional<Place> findByXAndY(Double x, Double y);
}