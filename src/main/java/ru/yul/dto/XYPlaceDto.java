package ru.yul.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class XYPlaceDto {

    private final Double x;
    private final Double y;
}
