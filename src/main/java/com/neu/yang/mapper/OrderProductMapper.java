package com.neu.yang.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.OrderProduct;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderProductMapper extends Mapper<OrderProduct> {
    List<OrderProduct> queryOrderProduct(String orderNumber);
}
