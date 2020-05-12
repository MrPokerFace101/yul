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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_pkey_generator")
    @SequenceGenerator(name="route_pkey_generator", sequenceName = "route_pkey_inc", allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private Double rating;
    private Long ratesAmount;

    @ManyToMany
    private List<Place> placeList;
}
