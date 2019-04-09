package com.neu.yang.entity;

import java.util.HashMap;
import java.util.List;

public class MyResult {
    private String[] roles;
    private String token;
    private String introduction;
    private String avatar;
    private String name;
//
//    private int code;
//    private HashMap<?,?> data;

    public MyResult() {
    }

    public MyResult(String[] roles, String token, String introduction, String avatar, String name) {
        this.roles = roles;
        this.token = token;
        this.introduction = introduction;
        this.avatar = avatar;
        this.name = name;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
