package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.dto.ProductResponseDTO;
import com.pet.project.mediahomeshop.entity.Category;
import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductCatalogControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductCatalogController productCatalogController;



    @Test
    void getProducts() {
        Category category = new Category();
        category.setId(1);
        category.setName("test category");

        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setCategory(category);
        List<Product> products = List.of(product);

        Page<Product> response = new PageImpl<>(products, PageRequest.of(0, 10), 1);

        when(productService.getAllProducts(null, null, null, null, PageRequest.of(0, 10)))
                .thenReturn(response);

        ProductResponseDTO result = productCatalogController.getProducts(null, null, null, null, 0, 10);

        assertNotNull(result);
        assertEquals(0, result.getPage());
        assertEquals(10, result.getSize());
        assertEquals(product, result.getItems().get(0));
    }
}