package com.ars.productservice.adapter.out.persistence;

import com.ars.productservice.application.port.out.ProductRepository;
import com.ars.productservice.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> products = new HashMap<>();
    @Override
    public Product save(Product product){
        products.put(product.getId(),product);
        return product;
    }
    @Override
    public Optional<Product> findById(String id) {
        return Optional.ofNullable(products.get(id));
    }

}
