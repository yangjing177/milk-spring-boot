package com.neu.yang.entity;

public class Users {
    private String id;
    private String username;
    private String mobile;
    private String password;

    public Users() {
    }

    public Users(String id, String username, String mobile, String password) {
        this.id = id;
        this.username = username;
        this.mobile = mobile;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
