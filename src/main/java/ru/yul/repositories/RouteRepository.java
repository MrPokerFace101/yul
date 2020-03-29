package ru.yul.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.Route;

import java.util.List;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("update Route set Route.rating = #{route.rating}, Route.ratesAmount = #{route.ratesAmount} where Route.id = #{route.id}")
    Route updateRouteRating(Route route);

    @Query("from Route order by rating desc")
    List<Route> findAllOrderByRating();
}
