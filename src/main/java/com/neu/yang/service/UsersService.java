package com.neu.yang.service;

import com.neu.yang.entity.User;
import com.neu.yang.model.Users;

import java.util.Map;

public interface UsersService {
    Map<String, Object> login(String username, String password);
    Map<String,Object> register(Users users);
    Map<String, Object> findAll();
    void update(Users users);
    Users findUser(String user);
}
