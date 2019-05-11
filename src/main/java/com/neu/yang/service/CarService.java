package com.neu.yang.service;

import com.neu.yang.model.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    List<Car> findCars(String user);
    void update(Car car);
    List<Car> insert(Car car);
    void delAll(String[] ids);
    int findCarCount(String user);

}
