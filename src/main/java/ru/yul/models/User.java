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
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String deviceId;

    @ManyToMany
    private List<Place> visitedPlaces;

    @ManyToMany
    private List<Route> savedRoutes;
}
