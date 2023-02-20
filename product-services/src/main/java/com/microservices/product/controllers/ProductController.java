package com.microservices.product.controllers;

import com.microservices.product.dto.ProductRequest;
import com.microservices.product.model.Product;
import com.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        System.out.println(productRequest);
        System.out.println(productService);
        productService.createProduct(productRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Product> getById(@Param("id") String id){
        return productService.getById(id);
    }


    @ResponseStatus(HttpStatus.OK)
    public List<Product> getByAll(){
        return productService.getAll();
    }

}
