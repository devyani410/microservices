package com.microservices.product.Repositry ;

import com.microservices.product.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
//import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositry extends MongoRepository<Product, String> {
}