package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
