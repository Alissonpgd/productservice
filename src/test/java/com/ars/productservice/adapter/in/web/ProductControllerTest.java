//package com.ars.productservice.adapter.in.web;
//
//import com.ars.productservice.adapter.in.ProductController;
//import com.ars.productservice.application.port.in.CreateProductUseCase;
//import com.ars.productservice.domain.Product;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//@WebMvcTest(ProductController.class) // Mantenha isso
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock // Mantenha isso, mas SEM @Autowired
//    private CreateProductUseCase createProductUseCase;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    void shouldCreateProductWhenValidInput() throws Exception { // Nomes de métodos mais descritivos
//        // Arrange
//        CreateProductUseCase.CreateProductCommand command = new CreateProductUseCase.CreateProductCommand("Produto Teste", 29.99);
//        Product createdProduct = new Product("123", "Produto Teste", 29.99);
//
//        when(createProductUseCase.createProduct(any(CreateProductUseCase.CreateProductCommand.class))).thenReturn(createdProduct);
//
//        // Act & Assert
//        mockMvc.perform(post("/products")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(command)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value("123"))
//                .andExpect(jsonPath("$.name").value("Produto Teste"))
//                .andExpect(jsonPath("$.price").value(29.99));
//    }
//
//    @Test
//    void shouldReturnProductWhenIdExists() throws Exception { // Nomes de métodos mais descritivos
//        //Arrange
//        Product product = new Product("123", "Produto Teste", 30.1);
//        when(createProductUseCase.getProduct(product.getId())).thenReturn(product);
//
//        // Act & Assert
//        mockMvc.perform(get("/products/{id}", product.getId()))
//                .andExpect(status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//}