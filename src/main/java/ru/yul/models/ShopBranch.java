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
public class ShopBranch {

    @Id
    @GeneratedValue
    private Long id;

    private Double x;
    private Double y;
}
