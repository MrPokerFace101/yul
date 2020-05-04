package ru.yul.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yul.models.Shop;
import ru.yul.models.ShopBranch;
import ru.yul.repositories.ShopBranchRepository;
import ru.yul.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopBranchRepository shopBranchRepository;

    public List<Shop> getAllShops() {
        List<Shop> res = new ArrayList<>();
        shopRepository.findAll().forEach(res::add);
        return res;
    }

    public Shop getById(Long id) {
        return shopRepository.findById(id).orElse(null);
    }

    public List<ShopBranch> findShopBranchesByShopId(Long id) {
        return shopBranchRepository.findAllByShopId(id);
    }

    public ShopBranch getBranch(Long shopId, Long branchId) {
//        return shopBranchRepository.findByShopIdAndBranchId(shopId, branchId);
//        TODO fix
        return null;
    }
}
