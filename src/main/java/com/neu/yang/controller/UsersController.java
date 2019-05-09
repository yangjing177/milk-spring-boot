package com.neu.yang.controller;

import com.neu.yang.entity.Info;
import com.neu.yang.model.Users;
import com.neu.yang.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @Autowired
    private HttpServletRequest request;

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {
        return usersService.login(username, password);
    }

    @ResponseBody
    @PostMapping("/logout")
    public Map<String, Object> logout() {
        String token=request.getHeader("x-token");
        String[] n={token};
        Map<String,Object> map=new HashMap<>();
        Info info=new Info();
        info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("code",20000);
        info.setRoles(n);
        info.setRole(token);
        info.setName(token);
        info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("data",info);
        return map;
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

    @ResponseBody
    @PostMapping("/findByUsername")
    public Users findByUsername(@RequestBody String user) {
        Users list=usersService.findUser(user);
        return list;
    }

    @ResponseBody
    @PostMapping("updateUser")
    public Users updateUser(@RequestBody Users users) {
        usersService.update(users);
        return usersService.findUser(users.getUsername());
    }
}
