package com.ars.productservice.application.port.out;

import com.ars.productservice.domain.Product;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(String id);
}
