package com.pet.project.mediahomeshop.dao;

import com.pet.project.mediahomeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
