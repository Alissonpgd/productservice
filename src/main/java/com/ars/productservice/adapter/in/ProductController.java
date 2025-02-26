package com.ars.productservice.adapter.in;

import com.ars.productservice.application.port.in.CreateProductUseCase;
import com.ars.productservice.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductUseCase.CreateProductCommand command){
        Product createProduct = createProductUseCase.createProduct(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(createProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        Product product = createProductUseCase.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
