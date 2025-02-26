package com.ars.productservice.adapter.out.kafka;

import com.ars.productservice.application.port.out.ProductEventPublisher;
import com.ars.productservice.avro.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProductEventPublisher implements ProductEventPublisher {

    private final KafkaTemplate<String, ProductEvent> kafkaTemplate;

    @Override
    public void publishProductCreated(ProductEvent event){
        kafkaTemplate.send("product-events", event.getId().toString(), event);
        log.info("Evento de produto criado publicado: {}", event);
    }
}
