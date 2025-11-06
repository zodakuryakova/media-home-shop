package com.pet.project.mediahomeshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="brand")
    private String brand;

    @Column(name="price")
    private double price;

    @Column(name="imageurl")
    private String imageUrl;

    @Column(name ="category_id")
    private int category_id;
}
