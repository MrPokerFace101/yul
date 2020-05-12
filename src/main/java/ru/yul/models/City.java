package ru.yul.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_pkey_inc")
    private Long id;

    private String name;

    @OneToMany
    private List<Route> routes;

    @OneToMany
    private List<Place> places;
}
