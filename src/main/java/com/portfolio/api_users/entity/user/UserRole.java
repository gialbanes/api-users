package com.portfolio.api_users.entity.user;

public enum UserRole {
    ADMIN("admin"),
    CUSTOMER("customer");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
