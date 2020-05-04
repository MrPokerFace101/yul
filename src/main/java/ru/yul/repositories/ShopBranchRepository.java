package ru.yul.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.yul.models.ShopBranch;

import java.util.List;

@Repository
public interface ShopBranchRepository extends CrudRepository<ShopBranch, Long> {

    @Query(nativeQuery = true, value = "select Shop.shopBranches from Shop where Shop.id = :id")
    List<ShopBranch> findAllByShopId(@Param("id")Long id);

    //TODO ????????????????????????
//    @Query("")
//    ShopBranch findByShopIdAndBranchId(Long shopId, Long branchId);
}
