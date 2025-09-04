package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.api_users.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
