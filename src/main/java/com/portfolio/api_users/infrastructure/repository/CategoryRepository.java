package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
