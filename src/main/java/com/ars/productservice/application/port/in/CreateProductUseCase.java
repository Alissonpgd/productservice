package com.ars.productservice.application.port.in;

import com.ars.productservice.domain.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public interface CreateProductUseCase {
    Product createProduct(@Valid CreateProductCommand command);

    Product getProduct(String id);

    record CreateProductCommand(
            @NotBlank(message = "Name não pode ser branco ou nulo")
            String name,

            @NotNull(message = "Price não pode ser nulo")
            @Positive(message = "Price precisa ser positivo")
            Double price
    ) {}
}
