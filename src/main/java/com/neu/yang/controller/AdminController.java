package com.neu.yang.controller;

import com.neu.yang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {
        return adminService.login(username, password);
    }

    @ResponseBody
    @GetMapping("/info")
    public Map<String, Object> login(@RequestParam String username) {
        return adminService.info(username);
    }
}
