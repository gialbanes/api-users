package com.portfolio.api_users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.portfolio.api_users.entity.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
}
