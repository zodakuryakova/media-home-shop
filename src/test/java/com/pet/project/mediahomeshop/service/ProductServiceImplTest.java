package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.entity.Category;
import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.repository.ProductRepository;
import com.pet.project.mediahomeshop.specification.ProductSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getAllProducts() {
        Category category = new Category();
        category.setId(1);
        category.setName("test category");

        Product product = new Product();
        product.setId(1);
        product.setName("test");
        product.setCategory(category);
        List<Product> products = List.of(product);


        when(productRepository.findAll(any(ProductSpecification.class))).thenReturn(products);

        assertEquals(
                productService.getAllProducts(1, null, null, null),
                products
        );

    }


}