package com.neu.yang.service;

import com.neu.yang.model.Admin;

import java.util.Map;

public interface AdminService {
    Map<String, Object> login(String username, String password);
    Map<String, Object> info(String username);
    Map<String, Object> findAll();
    void update(Admin admin);
    void save(Admin admin);
}
