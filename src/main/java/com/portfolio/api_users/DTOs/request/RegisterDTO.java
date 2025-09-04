package com.portfolio.api_users.DTOs.request;

import com.portfolio.api_users.entity.user.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {

}
