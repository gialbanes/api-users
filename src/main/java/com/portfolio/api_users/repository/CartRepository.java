package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.api_users.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
