package com.pet.project.mediahomeshop.controller;

import com.pet.project.mediahomeshop.dao.ProductRepository;
import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class Main {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }

}
