package com.neu.yang.controller;

import com.neu.yang.model.Car;
import com.neu.yang.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/car")
public class CarController {
    @Autowired
    CarService carService;

    @ResponseBody
    @PostMapping("/list")
    public List<Car> carList(@RequestBody String user) {
        List<Car> list=carService.findCars(user);
        return list;
    }

    @ResponseBody
    @PostMapping("/findCarCount")
    public int findCarCount(@RequestBody String user) {
        int count=carService.findCarCount(user);
        return count;
    }

    @ResponseBody
    @PostMapping("/update")
    public void update(@RequestBody Car car) {
        carService.update(car);
    }

    //批量删除
    @ResponseBody
    @PostMapping("/delAll")
    public void delAll(@RequestBody String[] ids) {
        carService.delAll(ids);
    }

    @ResponseBody
    @PostMapping("/insert")
    public List<Car> insert(@RequestBody Car car) {
        return carService.insert(car);
    }

}
