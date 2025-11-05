package com.pet.project.mediahomeshop.service;

import com.pet.project.mediahomeshop.dao.ProductRepository;
import com.pet.project.mediahomeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
