package com.neu.yang.controller;

import com.neu.yang.model.Users;
import com.neu.yang.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {
        return usersService.login(username, password);
    }

    @ResponseBody
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody Users users) {
        return usersService.register(users);
    }
}