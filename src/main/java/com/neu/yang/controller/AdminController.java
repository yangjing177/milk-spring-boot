package com.neu.yang.controller;

import com.neu.yang.model.Admin;
import com.neu.yang.model.Comment;
import com.neu.yang.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        Map<String, Object> map=adminService.findAll();
        return map;
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String, Object> insert(@RequestBody Admin admin) {
        admin.setId(null);
        admin.setCreateDate(new Date());
        admin.setUpdateDate(new Date());
        adminService.save(admin);
        return adminService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Admin admin) {
        admin.setUpdateDate(new Date());
        adminService.update(admin);
        return adminService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Admin admin) {
        admin.setIsDeleted(1);
        adminService.update(admin);
        return adminService.findAll();
    }
}
