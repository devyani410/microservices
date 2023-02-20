//package com.microservices.product.service;
//
//
//import com.microservices.product.Repositry.ProductRepositry;
//import com.microservices.product.model.Product;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class ProductService  {
//
//    private ProductRepositry productRepositry;
//
////    public ProductService(ProductRepositry productRepositry) {
////        this.productRepositry = productRepositry;
////    }
//
//    public void createProduct(Product product){
//        productRepositry.save(product);
//    }
//
//    public void createAllProduct(ArrayList<Product> listOfProduct) {productRepositry.saveAll(listOfProduct);
//    }
//    public Optional<Product> getById(String id){
//      return   productRepositry.findById(id);
//    }
//}
package com.microservices.product.service;

import com.microservices.product.Repositry.ProductRepositry;
//import com.microservices.product.dto.ProductRequest;
//import com.programmingtechie.productservice.dto.ProductResponse;
import com.microservices.product.dto.ProductRequest;
import com.microservices.product.model.Product;
//import com.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ProductService {

    private  ProductRepositry productRepositry;

    public ProductService(ProductRepositry productRepositry) {
        this.productRepositry = productRepositry;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product=Product.builder().name(productRequest.getName()).
                description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        System.out.println(product);
        productRepositry.save(product);
    }

    public void createAllProduct(ArrayList<Product> listOfProduct) {
        productRepositry.saveAll(listOfProduct);
    }

    public Optional<Product> getById(String id) {
        return productRepositry.findById(id);
    }

    public List<Product> getAll() {
        return productRepositry.findAll();
    }
}