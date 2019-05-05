package com.neu.yang.mapper;

import com.neu.yang.model.Goods;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Users;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface UsersMapper extends Mapper<Users> {
    Users login(@Param("username") String username, @Param("password") String password);
    Users findName(String username);
    List<Users> findAll();
}
