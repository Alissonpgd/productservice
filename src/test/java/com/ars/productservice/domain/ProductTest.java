package com.ars.productservice.domain;

import com.ars.productservice.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    void createProduct() {
        Product product = new Product("123", "Produto Teste", 10.0);
        assertEquals("123", product.getId());
        assertEquals("Produto Teste", product.getName());
        assertEquals(10.0, product.getPrice());
    }
}
