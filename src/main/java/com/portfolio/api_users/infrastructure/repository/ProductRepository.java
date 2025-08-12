package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
