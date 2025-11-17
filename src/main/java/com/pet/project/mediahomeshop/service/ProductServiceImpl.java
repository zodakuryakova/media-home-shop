package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.repository.ProductRepository;
import com.pet.project.mediahomeshop.entity.Product;
import com.pet.project.mediahomeshop.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts(Integer categoryId, Double minPrice, Double maxPrice, String brand) {
        return productRepository.findAll(
                new ProductSpecification(categoryId, minPrice, maxPrice, brand)
        );
    }

    @Override
    public Page<Product> getAllProducts(Integer categoryId, Double minPrice, Double maxPrice, String brand, Pageable pageable) {
        return productRepository.findAll(
                new ProductSpecification(categoryId, minPrice, maxPrice, brand),
                pageable
        );
    }
}
