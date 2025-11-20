package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.dto.ProductResponseDTO;
import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.exception.NoSuchProductException;
import com.pet.project.mediahomeshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductCatalogController {

    private final ProductService productService;

    @GetMapping
    public ProductResponseDTO getProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {

        Pageable pageable = PageRequest.of(page, size);

        Page<Product> response = productService.getAllProducts(categoryId, minPrice, maxPrice, brand, pageable);

        return new ProductResponseDTO(
                response.getNumber(),
                response.getSize(),
                response.getTotalPages(),
                response.getContent()
        );
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        Product product = productService.getProductById(id);

        if (product == null) {
            throw new NoSuchProductException("There is no product with id " + id);
        }
        return product;
    }


}
