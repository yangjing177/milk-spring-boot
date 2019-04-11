package com.neu.yang.service;

import java.util.Map;

public interface AdminService {
    Map<String, Object> login(String username, String password);
    Map<String, Object> info(String username);
}
