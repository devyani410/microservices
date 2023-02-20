package com.microservice.InventoryService.Repository;

import com.microservice.InventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepositry extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByskuCode(String skuCode);
}
