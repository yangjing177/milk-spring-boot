package com.neu.yang.service.impl;

import com.neu.yang.entity.MyResult;
import com.neu.yang.entity.User;
import com.neu.yang.model.Users;
import com.neu.yang.mapper.UsersMapper;
import com.neu.yang.service.UsersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Resource
    private UsersMapper usersMapper;

    /**
     * 添加
     * @param users
     */
    public void save(Users users){
        usersMapper.insert(users);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(String id){
        usersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param users
     */
    public void update(Users users){
        usersMapper.updateByPrimaryKey(users);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Users> findAll(){
        return usersMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Users findById(String id){
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Users u=new Users();
        MyResult result= new MyResult();
        u=usersMapper.login(username,password);
        Map<String,Object> map=new HashMap<>();
        if(u==null){
            map.put("code",0);
        }
        else {
            map.put("code",20000);
            String[] n={u.getUsername()};
            result.setRoles(n);
            result.setToken(u.getUsername());
            result.setIntroduction("我是超级管理员");
            result.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            result.setName("Super Admin");
            map.put("data",result);
        }
        return map;
    }
}
