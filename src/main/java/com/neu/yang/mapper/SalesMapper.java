package com.neu.yang.mapper;

import com.neu.yang.model.Sales;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface SalesMapper extends Mapper<Sales> {
    Sales queryByGoodId(Integer goodsId);
}
