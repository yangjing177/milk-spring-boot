package com.neu.yang.controller;

import com.neu.yang.model.Adress;
import com.neu.yang.model.Car;
import com.neu.yang.service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/adress")
public class AdressController {
    @Autowired
    AdressService adressService;

    @ResponseBody
    @PostMapping("/list")
    public List<Adress> adresseList(@RequestBody String user) {
        List<Adress> list=adressService.findAdress(user);
        return list;
    }
}
