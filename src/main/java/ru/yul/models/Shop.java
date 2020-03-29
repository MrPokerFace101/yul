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
@Getter
@Setter
public class Shop {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String code;

    @OneToMany
    private List<ShopBranch> shopBranches;
}
