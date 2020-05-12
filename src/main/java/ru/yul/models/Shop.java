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
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_pkey_generator")
    @SequenceGenerator(name="shop_pkey_generator", sequenceName = "shop_pkey_inc", allocationSize = 1)
    private Long id;
    private String name;
    private String code;

    @OneToMany
    private List<ShopBranch> shopBranches;
}
