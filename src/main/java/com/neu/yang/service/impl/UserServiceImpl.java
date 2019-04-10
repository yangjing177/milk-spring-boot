package com.neu.yang.service.impl;

import com.neu.yang.mapper.UserDao;
import com.neu.yang.entity.*;
import com.neu.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List queryUser(String uname, String upwd) {
        List<User> list= userDao.queryUser(uname,upwd);
        return list;

    }

    @Override
    public User findUname(String uname) {
        return userDao.findUname(uname);
    }

    @Override
    public int addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public Map<String, Object> login(String uname, String upwd) {
        User u=new User();
        MyResult result= new MyResult();
        u=userDao.login(uname,upwd);
        Map<String,Object> map=new HashMap<>();
        if(u==null){
            map.put("code",0);
        }
        else {
            map.put("code",20000);
            String[] n={u.getUname()};
            result.setRoles(n);
            result.setToken(u.getUname());
            result.setIntroduction("我是超级管理员");
            result.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            result.setName("Super Admin");
            map.put("data",result);
        }
        return map;
    }

    @Override
    public Map<String, Object> info(String uname) {
        User u=userDao.findUname(uname);
        Info info=new Info();
        Map<String,Object> map=new HashMap<>();
        if(u==null){
            map.put("code",0);
        }
        else{
            map.put("code",20000);
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            String[] n={u.getUname()};
            info.setRoles(n);
            info.setRole(u.getUname());
            info.setName(u.getUname());
            info.setName(u.getUname());
            map.put("data",info);
        }
        return map;
    }

    @Override
    public Map<String, Object> findAll() {
        List<Person> list=userDao.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=userDao.findNumber();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }

    @Override
    public Map<String, Object> update(Update data) {
        userDao.update(data);
        List<Person> list=userDao.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=userDao.findNumber();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }

    @Override
    public Map<String, Object> delete(Update data) {
        userDao.delete(data);
        List<Person> list=userDao.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=userDao.findNumber();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }

    @Override
    public Map<String, Object> addPerson(Person data) {
        Map<String,Object> map=new HashMap<>();
        userDao.addPerson(data);
        map.put("code",20000);
        return map;
    }

    @Override
    public Map<String,Object> findKu() {
        List<Personku> list=userDao.findKu();
        Map<String,Object> map=new HashMap<>();
        int totalRow=list.size();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }


}
