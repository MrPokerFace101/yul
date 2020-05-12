package ru.yul.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "place_pkey_generator")
    @SequenceGenerator(name="place_pkey_generator", sequenceName = "place_pkey_inc", allocationSize = 1)
    private Long id;

    private String name;
    private String description;
    private Double rating;
    private Long ratesAmount;
    private Double x;
    private Double y;
}
