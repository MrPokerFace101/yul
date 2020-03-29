package ru.yul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yul.dto.RouteDto;
import ru.yul.models.Route;
import ru.yul.services.RouteService;

import java.util.List;

@RestController
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/api/{city}/routes")
    public ResponseEntity<Route> saveRoute(@RequestBody RouteDto routeDto, @PathVariable String city) {
        return ResponseEntity.ok(routeService.saveRoute(routeDto));
    }

    @PutMapping("/api/routes/{id}")
    public ResponseEntity<Route> updateRouteRating(@PathVariable Long id, Integer rating) {
        Route route = routeService.updateRouteRating(id, rating);
        return route == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(route);
    }

    @GetMapping("/api/{city}/routes")
    public ResponseEntity<List<Route>> getHighestRatedRoutes(@PathVariable String city) {
        List<Route> routes = routeService.getHighestRatedRoutes();
        return routes == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(routes);
    }

    @GetMapping("/api/routes/{id}")
    public ResponseEntity<Route> getRoute(@PathVariable Long id) {
        Route route = routeService.getById(id);
        return route == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(route);
    }
}
