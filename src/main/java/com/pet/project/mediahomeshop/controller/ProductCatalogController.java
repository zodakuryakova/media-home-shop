package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductCatalogController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {

        return productService.getAllProducts(categoryId, minPrice, maxPrice, brand);
    }


//    @GetMapping("/{id}")


}
