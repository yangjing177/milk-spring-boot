package com.neu.yang.controller;


import com.neu.yang.dto.PersonDto;
import com.neu.yang.entity.*;
import com.neu.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {
        return userService.login(username, password);
    }

    @ResponseBody
    @GetMapping("/info")
    public Map<String, Object> login(@RequestParam String username) {
        return userService.info(username);
    }
    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        return userService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Update data) {
        userService.update(data);
        return userService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Update data) {
        userService.delete(data);
        return userService.findAll();
    }

    @ResponseBody
    @PostMapping("add")
    public Map<String, Object> update(@RequestBody PersonDto data) {


        String str= new String();
        for(int i=0;i<data.getSpace().length;i++){
            str+=data.getSpace()[i];
        }
        Person person = new Person(data.getUid(),data.getDate(),data.getCname(),data.getTitle(),data.getStatus(),data.getNumber(),data.getType(),str,data.getIntroduce());
//        person.setSpace(data.getSpace());
        userService.addPerson(person);
        return userService.findAll();
    }

    @ResponseBody
    @GetMapping("/kucun")
    public Map<String,Object> getList1() {
        return userService.findKu();
    }

}
