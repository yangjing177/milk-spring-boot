package com.neu.yang.mapper;

import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Address;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface AddressMapper extends Mapper<Address> {
    List<Address> findAddress(String user);
}
