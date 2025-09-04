package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.api_users.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
