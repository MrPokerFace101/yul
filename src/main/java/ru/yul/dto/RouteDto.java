package ru.yul.dto;

import lombok.*;
import ru.yul.models.Place;
import ru.yul.models.Route;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class RouteDto {

    private final String name;
    private final String description;
    private final List<Place> places;

    public Route toRoute() {
        return Route.builder()
                .name(name)
                .description(description)
                .placeList(places)
                .build();
    }
}
