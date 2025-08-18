package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
