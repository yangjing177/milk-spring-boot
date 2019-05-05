package com.neu.yang.controller;

import com.neu.yang.model.Goods;
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

    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        return usersService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Users users) {
        usersService.update(users);
        return usersService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Users users) {
        users.setIsDeleted(1);
        usersService.update(users);
        return usersService.findAll();
    }
}
