package ru.yul.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private Double rating;
    private Long ratesAmount;
    private Double x;
    private Double y;
}
