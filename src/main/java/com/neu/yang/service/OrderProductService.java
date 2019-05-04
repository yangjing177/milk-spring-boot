package com.neu.yang.service;

import com.neu.yang.model.Car;

import java.util.List;

public interface OrderProductService {
    int insertOrderProduct(String orderNum, List<Car> cars);
}
