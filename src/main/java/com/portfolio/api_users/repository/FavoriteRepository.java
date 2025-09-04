package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.api_users.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
