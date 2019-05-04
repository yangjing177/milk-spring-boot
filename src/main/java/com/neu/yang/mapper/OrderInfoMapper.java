package com.neu.yang.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.OrderInfo;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface OrderInfoMapper extends Mapper<OrderInfo> {
    List<OrderInfo> findOrderInfo(@Param("orderStatus")String orderStatus, @Param("user")String user);
}
