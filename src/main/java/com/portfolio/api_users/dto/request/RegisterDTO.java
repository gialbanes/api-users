package com.portfolio.api_users.dto.request;

import com.portfolio.api_users.infrastructure.entity.user.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {

}
