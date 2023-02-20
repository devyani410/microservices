package com.microservice.InventoryService.controllers;

import com.microservice.InventoryService.model.Inventory;
import com.microservice.InventoryService.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean getBySkucode(@PathVariable String skuCode){
        return inventoryService.isInStock(skuCode);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> get(){
        return new ResponseEntity<>(inventoryService.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Inventory> add(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.add(inventory),HttpStatus.CREATED);
    }

    @GetMapping("{Id}")
    public ResponseEntity<Inventory> getById(@PathVariable Long id){
        Optional optional=inventoryService.getbyId(id);
        if(optional.isPresent()){
            return new ResponseEntity<>((Inventory) optional.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
