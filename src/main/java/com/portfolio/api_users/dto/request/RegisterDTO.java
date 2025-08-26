package com.portfolio.api_users.dto.request;

import com.portfolio.api_users.infrastructure.entity.user.UserRole;

public class RegisterDTO {

    private String email;
    private String password;
    private UserRole role;

    public RegisterDTO(String email, String password, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public UserRole getRole() { return role;}

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(UserRole role) { this.role = role;}
}
