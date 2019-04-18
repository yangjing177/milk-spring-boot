package com.neu.yang.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Car;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface CarMapper extends Mapper<Car> {
    List<Car> findCars(String user);
    List<Car> findName(@Param("user") String user,@Param("goodsName") String goodsName);
    int delAll(String[] ids);
}
