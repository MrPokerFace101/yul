package ru.yul.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.yul.models.City;
import ru.yul.services.CityService;

import java.util.List;

@RestController
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/api/cities")
    public ResponseEntity<List<City>> getAll() {
        log.debug("getAll();");
        return ResponseEntity.ok(cityService.getAll());
    }

    @GetMapping("/api/cities/{city}")
    public ResponseEntity<City> getByName(@PathVariable String city) {
        log.debug("getByName(); city={}", city);
        City returnCity = cityService.getByName(city);
        if(returnCity == null) {
            log.error("getByName() returned 404; city= {}", city);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(returnCity);
        }

    }
}
