package ru.yul.controllers;

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
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/api/shops")
    public ResponseEntity<List<Shop>> getAllShops() {
        return ResponseEntity.ok(shopService.getAllShops());
    }

    @GetMapping("/api/shops/{shop_id}")
    public ResponseEntity<Shop> getShop(@PathVariable("shop_id") Long id) {
        Shop shop = shopService.getById(id);
        return shop == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(shop);
    }

    @GetMapping("/api/shops/{shop_id}/branches")
    public ResponseEntity<List<ShopBranch>> getAllBranches(@PathVariable("shop_id") Long id) {
        return ResponseEntity.ok(shopService.findShopBranchesByShopId(id));
    }

    @GetMapping("/api/shops/{shop_id}/branches/{branch_id}")
    public ResponseEntity<ShopBranch> getBranch(@PathVariable("shop_id") Long shopId, @PathVariable("branch_id") Long branchId) {
        return ResponseEntity.ok(shopService.getBranch(shopId, branchId));
    }
}
