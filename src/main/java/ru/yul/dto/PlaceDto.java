package ru.yul.dto;

import lombok.*;
import ru.yul.models.Place;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class PlaceDto {

    private String name;
    private String description;
    private Double x;
    private Double y;

    public Place toPlace() {
        return Place.builder()
                .name(name)
                .description(description)
                .x(x)
                .y(y)
                .build();
    }
}
