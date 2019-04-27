package com.neu.yang.controller;

import com.neu.yang.model.Car;
import com.neu.yang.model.OrderInfo;
import com.neu.yang.service.OrderInfoService;
import com.neu.yang.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    OrderProductService orderProductService;

    @ResponseBody
    @PostMapping("/insert")
    public List<Car> insert(@RequestBody OrderInfo orderInfo ,@RequestBody Car car) {
        String str="";
        return null;
    }

}
