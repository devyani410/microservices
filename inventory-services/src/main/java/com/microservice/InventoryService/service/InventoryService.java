package com.microservice.InventoryService.service;

import com.microservice.InventoryService.Repository.InventoryRepositry;
import com.microservice.InventoryService.model.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InventoryService {
    private final InventoryRepositry inventoryRepositry;

    @Transactional(readOnly = true)
    public boolean isInStock(String skucode){
        return inventoryRepositry.findByskuCode(skucode).isPresent();
    }

    public List<Inventory> get(){
        return inventoryRepositry.findAll();
    }



    public Inventory add(Inventory inventory ){
       return inventoryRepositry.save(inventory);
    }

    public Optional<Inventory> getbyId(Long id) {
        return inventoryRepositry.findById(id);
    }
}
