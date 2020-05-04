package ru.yul.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yul.dto.RouteDto;
import ru.yul.models.Route;
import ru.yul.repositories.RouteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route saveRoute(RouteDto routeDto) {
        Route route = routeDto.toRoute();
        route.setRating(0.0);
        route.setRatesAmount(0L);
        route = routeRepository.save(route);
        return route;
    }

    public Route updateRouteRating(Long id, Integer rating) {
        Optional<Route> routeOptional = routeRepository.findById(id);
        if(routeOptional.isPresent()) {
            Route route = routeOptional.get();
            route.setRating((route.getRating() * route.getRatesAmount() + rating) / (route.getRatesAmount() + 1));
            route.setRatesAmount(route.getRatesAmount() + 1);
            int changedAmount = routeRepository.updateRouteRating(route.getRating(), route.getRatesAmount(), route.getId());
            if(changedAmount == 1) {
                return route;
            } else { //TODO decide what to do if amount is more than 1
                return null;
            }
        } else {
            return null;
        }
    }

    public List<Route> getHighestRatedRoutes() {
        return routeRepository.findAllOrderByRating();
    }

    public Route getById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }
}
