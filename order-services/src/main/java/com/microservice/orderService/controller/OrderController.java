package com.microservice.orderService.controller;

import com.microservice.orderService.dto.OrderRequest;
import com.microservice.orderService.model.Order;
import com.microservice.orderService.services.OrderServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServices orderService;
    @PostMapping
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.save(orderRequest);
        return "order placed successfully!";
    }
    @GetMapping
    public ResponseEntity<List<Order>> getOrder(){
        return new ResponseEntity<>(orderService.get(), HttpStatus.OK);
    }
}
