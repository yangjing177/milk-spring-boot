package com.neu.yang.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Adress;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AdressMapper extends Mapper<Adress> {
    List<Adress> findAdress(String user);
}
