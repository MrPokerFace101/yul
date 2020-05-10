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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_pkey")
    private Long id;
    private String name;
    private String deviceId;

    @ManyToMany
    private List<Place> visitedPlaces;

    @ManyToMany
    private List<Route> visitedRoutes;

    @ManyToMany
    private List<Route> savedRoutes;
}
