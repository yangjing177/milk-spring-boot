package com.neu.yang.service;

import com.neu.yang.model.OrderInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderInfoService {
    String insertOrderInfo(OrderInfo orderInfo);
    List<OrderInfo> findOrderInfo(String orderStatus,String user);
    void update(OrderInfo orderinfo);
}
