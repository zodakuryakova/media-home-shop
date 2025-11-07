package com.pet.project.mediahomeshop.repository;

import com.pet.project.mediahomeshop.entity.Product;
import net.datafaker.providers.base.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ProductRepository extends
        JpaRepository<Product, Integer>,
        JpaSpecificationExecutor<Product> {

}
