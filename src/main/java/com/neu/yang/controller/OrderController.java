package com.neu.yang.controller;

import com.neu.yang.dto.OrderInfoDto;
import com.neu.yang.dto.Selected;
import com.neu.yang.model.Car;
import com.neu.yang.model.Goods;
import com.neu.yang.model.OrderInfo;
import com.neu.yang.service.OrderInfoService;
import com.neu.yang.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    OrderProductService orderProductService;

    @ResponseBody
    @PostMapping("/insertOrderInfo")
    public String insertOrderInfo(@RequestBody OrderInfo orderInfo) {
        String orderNum=orderInfoService.insertOrderInfo(orderInfo);
        return orderNum;
    }

    @ResponseBody
    @PostMapping("/insertOrderProduct")
    public int insertOrderProduct(@RequestParam String orderNum, @RequestBody List<Car> cars) {
        return orderProductService.insertOrderProduct(orderNum,cars);
    }

    @ResponseBody
    @PostMapping("/queryOrderInfo")
    public List<OrderInfo> queryOrderInfo(@RequestBody OrderInfoDto orderInfoDto ) {
        List<OrderInfo> list=orderInfoService.findOrderInfo(orderInfoDto.getOrderStatus(),orderInfoDto.getUser());
        return list;
    }


    @ResponseBody
    @PostMapping("/updateOrderStatus")
    public void updateOrderStatus(@RequestBody OrderInfo orderInfo) {
        orderInfoService.update(orderInfo);
    }

    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        return orderInfoService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody OrderInfo orderInfo) {
        orderInfoService.update(orderInfo);
        return orderInfoService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody OrderInfo orderInfo) {
        orderInfo.setIsDeleted(1);
        orderInfoService.update(orderInfo);
        return orderInfoService.findAll();
    }
}
