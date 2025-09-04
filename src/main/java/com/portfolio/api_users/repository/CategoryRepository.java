package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.api_users.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
