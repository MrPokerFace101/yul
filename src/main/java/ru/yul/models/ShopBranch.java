package ru.yul.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ShopBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_branch_pkey_generator")
    @SequenceGenerator(name="shop_branch_pkey_generator", sequenceName = "shop_branch_pkey_inc", allocationSize = 1)
    private Long id;

    private Double x;
    private Double y;
}
