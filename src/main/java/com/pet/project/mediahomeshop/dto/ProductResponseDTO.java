package com.pet.project.mediahomeshop.dto;

import com.pet.project.mediahomeshop.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProductResponseDTO {
    private int page;
    private int size;
    private int total;
    private List<Product> items;
}
