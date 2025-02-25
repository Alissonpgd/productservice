package com.ars.productservice.application.port.out;

import com.ars.productservice.avro.ProductEvent; // Importa a classe ProductEvent gerada

public interface ProductEventPublisher {
    void publishProductCreated(ProductEvent event);
}
