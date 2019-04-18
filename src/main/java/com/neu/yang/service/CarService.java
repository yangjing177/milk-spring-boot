package com.neu.yang.service;

import com.neu.yang.model.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarService {
    List<Car> findAll();
    List<Car> findCars(String user);
    void update(Car car);
    void insert(Car car);
    void delAll(String[] ids);
    int findCarCount(String user);

}
