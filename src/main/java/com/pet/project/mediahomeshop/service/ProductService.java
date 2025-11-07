package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts(Integer categoryId, Double minPrice, Double maxPrice, String brand);

}
