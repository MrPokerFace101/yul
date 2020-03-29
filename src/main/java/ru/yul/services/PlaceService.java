package ru.yul.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yul.dto.PlaceDto;
import ru.yul.models.Place;
import ru.yul.repositories.PlaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> getPlacesByCity(String city) {
        return placeRepository.findByCity(city);
    }

    public Place save(PlaceDto placeDto) {
        Place place = placeDto.toPlace();
        place.setRating(0.0);
        place.setRatesAmount(0L);
        return placeRepository.save(place);
    }

    public Place updatePlaceRatingById(Long id, Integer rating) {
        Optional<Place> placeOptional = placeRepository.findById(id);
        if(placeOptional.isPresent()) {
            Place place = placeOptional.get();
            place.setRating((place.getRating() * place.getRatesAmount() + rating) / (place.getRatesAmount() + 1));
            place = placeRepository.updatePlaceRating(place);
            return place;
        } else {
            return null;
        }
    }
}
