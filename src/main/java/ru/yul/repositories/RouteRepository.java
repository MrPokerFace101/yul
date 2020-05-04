package ru.yul.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yul.models.Route;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "update route set route.rating = :routeRating, route.ratesAmount = :ratesAmount where route.id = :routeId")
    int updateRouteRating(@Param("routeRating") Double routeRating, @Param("ratesAmount") Long ratesAmount, @Param("routeId") Long routeId);

    @Query("from Route order by rating desc")
    List<Route> findAllOrderByRating();
}
