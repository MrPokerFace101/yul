package ru.yul.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double rating;
    private Long ratesAmount;

    @ManyToMany
    private List<Place> placeList;
}
