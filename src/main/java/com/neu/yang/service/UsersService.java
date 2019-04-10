package com.neu.yang.service;

import java.util.Map;

public interface UsersService {
    Map<String, Object> login(String username, String password);
}
