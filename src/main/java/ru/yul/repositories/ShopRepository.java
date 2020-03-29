package ru.yul.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
}
