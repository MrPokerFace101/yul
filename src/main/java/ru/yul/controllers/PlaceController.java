package ru.yul.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yul.dto.PlaceDto;
import ru.yul.dto.XYPlaceDto;
import ru.yul.models.Place;
import ru.yul.services.CityService;
import ru.yul.services.PlaceService;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class PlaceController {

    @Autowired
    private PlaceService placeService;
    @Autowired
    private CityService cityService;

    @GetMapping("/api/{city}/places")
    public ResponseEntity<List<XYPlaceDto>> getPlacesByCity(@PathVariable String city) {
        log.debug("getPlacesByCity(); city={}", city);
        List<XYPlaceDto> places = placeService.getPlacesCoordinatesByCity(city);
        if (places.isEmpty()) {
            log.error("getPlacesByCity; places is empty; 404 response code sent");
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(places);
        }
    }

    @GetMapping("/api/{city}/places/place")
    public ResponseEntity<Place> getPlaceByCoordinates(@PathVariable String city, @RequestBody XYPlaceDto placeDto) {
        log.debug("getPlaceByCoordinates(); city={}; x={}; y={}", city, placeDto.getX(), placeDto.getY());
        Optional<Place> placeOptional = placeService.findByCoordinates(placeDto.getX(), placeDto.getY());
        if (!placeOptional.isPresent()) {
            log.error("getPlaceByCoordinates 404 not found; x={}; y={}", placeDto.getX(), placeDto.getY());
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(placeOptional.get());
        }
    }

    @PostMapping("/api/{city}/places")
    public ResponseEntity<Place> savePlace(@PathVariable String city, @RequestBody PlaceDto placeDto) {
        log.debug("savePlace(); city={}", city);
        if(placeDto == null) {
            log.error("savePlace(); placeDto is null; badRequest code sent");
            return ResponseEntity.badRequest().build();
        } else {
            Place place = placeService.save(placeDto);
            cityService.addPlaceToCityList(city, place.getId());
            return ResponseEntity.ok(place);
        }
    }

    @PutMapping("/api/places/{id}")
    public ResponseEntity<Place> updatePlaceRating(@PathVariable Long id, Integer rating) {
        log.debug("updatePlaceRating(); placeId={}; rating={}", id, rating);
        Place place = placeService.updatePlaceRatingById(id, rating);
        if(place == null) {
            log.error("updatePlaceRating 404 not found; id={}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(place);
        }
    }
}
