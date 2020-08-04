package com.pescaria.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pescaria.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
