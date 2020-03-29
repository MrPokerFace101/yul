package ru.yul.dto;

import lombok.*;
import ru.yul.models.Place;
import ru.yul.models.Route;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RouteDto {

    private String name;
    private String description;
    private List<Place> places;

    public Route toRoute() {
        return Route.builder()
                .name(name)
                .description(description)
                .route(places)
                .build();
    }
}
