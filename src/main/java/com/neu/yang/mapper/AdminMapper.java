package com.neu.yang.mapper;

import com.neu.yang.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;
import com.neu.yang.model.Admin;
@org.apache.ibatis.annotations.Mapper
public interface AdminMapper extends Mapper<Admin> {
    Admin login(@Param("username") String username, @Param("password") String password);
    Admin findUname(@Param("username") String username);
}
