package com.neu.yang.mapper;

import com.neu.yang.entity.Person;
import com.neu.yang.entity.Personku;
import com.neu.yang.entity.Update;
import com.neu.yang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserDao {
    List queryUser(@Param("uname") String uname, @Param("upwd") String upwd);
    User findUname(@Param("uname") String uname);
    int addUser(User u);
    User login(@Param("uname") String uname, @Param("upwd") String upwd);
    List<Person> findAll();
    int findNumber();
    int update(Update data);
    int delete(Update data);
    int addPerson(Person data);
    List<Personku> findKu();
}
