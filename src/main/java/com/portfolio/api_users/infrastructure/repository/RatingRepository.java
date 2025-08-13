package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
