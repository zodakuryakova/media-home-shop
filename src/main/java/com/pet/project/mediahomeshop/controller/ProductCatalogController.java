package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductCatalogController {
    @Autowired
    ProductService productService;

    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }





}
