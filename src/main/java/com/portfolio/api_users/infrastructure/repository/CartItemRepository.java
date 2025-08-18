package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
