package ru.yul.dto;

import lombok.*;
import ru.yul.models.Place;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlaceDto {

    private final String name;
    private final String description;
    private final Double x;
    private final Double y;

    public Place toPlace() {
        return Place.builder()
                .name(name)
                .description(description)
                .x(x)
                .y(y)
                .build();
    }
}
