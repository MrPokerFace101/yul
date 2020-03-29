package ru.yul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.yul.models.City;
import ru.yul.services.CityService;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/api/cities")
    public ResponseEntity<List<City>> getAll() {
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/api/cities/{city}")
    public ResponseEntity<City> getByName(@PathVariable String city) {
        return ResponseEntity.ok(cityService.getByName(city));
    }
}
