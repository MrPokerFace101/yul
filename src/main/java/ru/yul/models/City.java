package ru.yul.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class City {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<Route> routes;

    @OneToMany
    private List<Place> places;
}
