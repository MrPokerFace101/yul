package ru.yul.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yul.dto.RouteDto;
import ru.yul.models.Route;
import ru.yul.services.CityService;
import ru.yul.services.RouteService;

import java.util.List;

@RestController
@Slf4j
public class RouteController {

    @Autowired
    private RouteService routeService;
    @Autowired
    private CityService cityService;

    @PostMapping("/api/{city}/routes")
    public ResponseEntity<Route> saveRoute(@RequestBody RouteDto routeDto, @PathVariable String city) {
        log.debug("saveRoute(); city={}", city);
        if (routeDto == null) {
            log.error("saveRoute() bad request: routeDto is null");
            return ResponseEntity.badRequest().build();
        } else {
            Route route = routeService.saveRoute(routeDto);
            cityService.addRouteToCityList(city, route.getId());
            return ResponseEntity.ok(route);
        }
    }

    @PutMapping("/api/routes/{id}")
    public ResponseEntity<Route> updateRouteRating(@PathVariable Long id, Integer rating) {
        log.debug("updateRouteRating(); id={}; rating={}", id, rating);
        Route route = routeService.updateRouteRating(id, rating);
        if(route == null) {
            log.error("updateRouteRating() 404 not found; id={}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(route);
        }
    }

    @GetMapping("/api/{city}/routes")
    public ResponseEntity<List<Route>> getHighestRatedRoutes(@PathVariable String city) {
        log.debug("getHighestRatedRoutes(); city={}", city);
        List<Route> routes = routeService.getHighestRatedRoutes();
        if(routes == null) {
            log.error("getHighestRatedRoutes() 404 not found; city={}", city);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(routes);
        }
    }

    @GetMapping("/api/routes/{id}")
    public ResponseEntity<Route> getRoute(@PathVariable Long id) {
        log.debug("getRoute(); id={}", id);
        Route route = routeService.getById(id);
        if(route == null) {
            log.error("getRoute 404 not found; id={}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(route);
        }
    }
}
