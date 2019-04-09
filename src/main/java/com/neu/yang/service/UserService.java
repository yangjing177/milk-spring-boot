package com.neu.yang.service;

import com.neu.yang.entity.*;

import java.util.List;
import java.util.Map;

public interface UserService {
    List queryUser(String uname, String upwd);
    User findUname(String uname);
    int addUser(User u);
    Map<String, Object> login(String uname, String upwd);
    Map<String, Object> info(String uname);
    Map<String, Object> findAll();
    Map<String, Object> update(Update data);
    Map<String, Object> delete(Update data);
    Map<String, Object> addPerson(Person data);
    Map<String,Object> findKu();
}
