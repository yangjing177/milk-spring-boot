package com.neu.yang.service;

import com.neu.yang.model.Car;
import com.neu.yang.model.OrderProduct;

import java.util.List;

public interface OrderProductService {
    int insertOrderProduct(String orderNum, List<Car> cars);
    List<OrderProduct> queryOrderProduct(String orderNumber);
}
