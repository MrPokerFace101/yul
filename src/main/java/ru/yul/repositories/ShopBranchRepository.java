package ru.yul.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.yul.models.ShopBranch;

@Repository
public interface ShopBranchRepository extends CrudRepository<ShopBranch, Long> {
}
