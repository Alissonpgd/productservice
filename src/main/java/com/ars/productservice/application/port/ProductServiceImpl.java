package com.ars.productservice.application.port;


import com.ars.productservice.application.port.in.CreateProductUseCase;
import com.ars.productservice.application.port.out.ProductEventPublisher;
import com.ars.productservice.application.port.out.ProductRepository;
import com.ars.productservice.domain.ProductService;
import com.ars.productservice.avro.ProductEvent;
import com.ars.productservice.domain.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor //Lombok - Gera um construtor com os campos final
public class ProductServiceImpl implements ProductService, CreateProductUseCase {

    private final ProductRepository productRepository;
    private final ProductEventPublisher productEventPublisher;

    @Override
    public Product createProduct(CreateProductCommand command){

        // cria Produto
        Product product = new Product(
                UUID.randomUUID().toString(),
                command.name(),
                command.price()
        );

        // Salva no Repositorio
        Product savedProduct = productRepository.save(product);

        // Cria e Envia o Evento
        ProductEvent productEvent = ProductEvent.newBuilder()
                .setId(savedProduct.getId())
                .setName(savedProduct.getName())
                .setPrice(savedProduct.getPrice())
                .build();

        productEventPublisher.publishProductCreated(productEvent);

        return savedProduct;
    }


    @Override
    public Product getProduct(String id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não Encontrado"));
    }
    @Override
    public Product createProduct(Product product){

        return createProduct(new CreateProductUseCase.CreateProductCommand(product.getName(), product.getPrice()));
    }

}
