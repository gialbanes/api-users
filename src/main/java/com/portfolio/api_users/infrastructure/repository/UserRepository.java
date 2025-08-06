package com.portfolio.api_users.infrastructure.repository;

import com.portfolio.api_users.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
