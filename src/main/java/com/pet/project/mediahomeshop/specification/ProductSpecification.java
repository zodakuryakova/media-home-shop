package com.pet.project.mediahomeshop.specification;

import com.pet.project.mediahomeshop.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ProductSpecification implements Specification<Product> {
    private final Integer category_id;
    private final Double minPrice;
    private final Double maxPrice;
    private final String brand;

    @Override
    public Predicate toPredicate(
            Root<Product> root,
            CriteriaQuery<?> query,
            CriteriaBuilder criteriaBuilder
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if(category_id != null){
            predicates.add(criteriaBuilder.equal(root.get("category").get("id"), category_id));
        }
        if(minPrice != null){
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
        }
        if(maxPrice != null){
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
        }
        if(brand != null){
            predicates.add(criteriaBuilder.equal(root.get("brand"), brand));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
