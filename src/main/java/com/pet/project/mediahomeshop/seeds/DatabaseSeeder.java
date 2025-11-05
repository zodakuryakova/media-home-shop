package com.pet.project.mediahomeshop.seeds;

import com.pet.project.mediahomeshop.dao.ProductRepository;
import com.pet.project.mediahomeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("dev")
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        // Only seed if database is empty
        if (productRepository.count() == 0) {
            seedProducts();
        }
    }
    
    private void seedProducts() {
        List<Product> products = new ArrayList<>();
        
        for (int i = 0; i < 50; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
//            product.setPrice(new BigDecimal(faker.commerce().price()));
//            product.setDescription(faker.lorem().paragraph());
//            product.setCreatedAt(LocalDateTime.now());
            products.add(product);
        }
        
        productRepository.saveAll(products);
        System.out.println("✅ Seeded " + products.size() + " products");
    }
}