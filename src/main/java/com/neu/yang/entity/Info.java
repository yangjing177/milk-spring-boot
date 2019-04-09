package com.neu.yang.entity;

public class Info {
    private String avatar;
    private String[] roles;
    private String role;
    private String token;
    private String name;

    public Info() {
    }

    public Info(String avatar, String[] roles, String role, String token, String name) {
        this.avatar = avatar;
        this.roles = roles;
        this.role = role;
        this.token = token;
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
