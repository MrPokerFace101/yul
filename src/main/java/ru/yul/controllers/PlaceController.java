package ru.yul.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yul.dto.PlaceDto;
import ru.yul.models.Place;
import ru.yul.services.PlaceService;

import java.util.List;

@RestController
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/api/{city}/places")
    public ResponseEntity<List<Place>> getPlacesByCity(@PathVariable String city) {
        List<Place> places = placeService.getPlacesByCity(city);
        return places == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(places);
    }

    @PostMapping("/api/{city}/places")
    public ResponseEntity<Place> savePlace(@PathVariable String city, @RequestBody PlaceDto placeDto) {
        //TODO decide what to do with the city
        return ResponseEntity.ok(placeService.save(placeDto));
    }

    @PutMapping("/api/places/{id}")
    public ResponseEntity<Place> updatePlaceRating(@PathVariable Long id, Integer rating) {
        Place place = placeService.updatePlaceRatingById(id, rating);
        return place == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(place);
    }
}
