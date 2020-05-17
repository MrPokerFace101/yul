package ru.yul.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.yul.models.Shop;
import ru.yul.models.ShopBranch;
import ru.yul.services.ShopService;

import java.util.List;

@RestController
@Slf4j
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/api/shops")
    public ResponseEntity<List<Shop>> getAllShops() {
        log.debug("getAllShops();");
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping("/api/shops/{shop_id}")
    public ResponseEntity<Shop> getShop(@PathVariable("shop_id") Long id) {
        log.debug("getShop(); id={}", id);
        Shop shop = shopService.getById(id);
        if (shop == null) {
            log.error("getShop() 404 not found; id={}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(shop);
        }
    }

    @GetMapping("/api/shops/{shop_id}/branches")
    public ResponseEntity<List<ShopBranch>> getAllBranches(@PathVariable("shop_id") Long id) {
        log.debug("getAllBranches(); id={}", id);
        List<ShopBranch> shopBranchList = shopService.findShopBranchesByShopId(id);
        if (shopBranchList == null) {
            log.error("getAllBranches() 404 not found; id={}", id);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(shopService.findShopBranchesByShopId(id));
        }
    }

    @GetMapping("/api/shops/{shop_id}/branches/{branch_id}")
    public ResponseEntity<ShopBranch> getBranch(@PathVariable("shop_id") Long shopId, @PathVariable("branch_id") Long branchId) {
        log.debug("getBranch(); shopId={}; branchId={}", shopId, branchId);
        ShopBranch shopBranch = shopService.getBranch(shopId, branchId);
        if(shopBranch == null) {
            log.error("getBranch(); 404 not found; shopId={}; branchId={}", shopId, branchId);
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(shopService.getBranch(shopId, branchId));
        }
    }
}
