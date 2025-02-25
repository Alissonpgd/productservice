package com.ars.productservice.domain;

public interface ProductService {
    Product createProduct(Product product); //Este não usamos, mas é do Dominio
    Product getProduct(String id);
}
