package com.neu.yang.service.impl;

import com.neu.yang.entity.Info;
import com.neu.yang.entity.MyResult;
import com.neu.yang.entity.User;
import com.neu.yang.mapper.AdminMapper;
import com.neu.yang.model.Admin;
import com.neu.yang.model.Users;
import com.neu.yang.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    /**
     * 添加
     * @param admin
     */
    public void save(Admin admin){
        adminMapper.insert(admin);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(String id){
        adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param admin
     */
    public void update(Admin admin){
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Admin> findAll(){
        return adminMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Admin findById(String id){
        return adminMapper.selectByPrimaryKey(id);
    }


    @Override
    public Map<String, Object> login(String username, String password) {
        Admin u=new Admin();
        MyResult result= new MyResult();
        u=adminMapper.login(username,password);
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

    @Override
    public Map<String, Object> info(String username) {
        Admin u=adminMapper.findUname(username);
        Info info=new Info();
        Map<String,Object> map=new HashMap<>();
        if(u==null){
            map.put("code",0);
        }
        else{
            map.put("code",20000);
            info.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            String[] n={u.getUsername()};
            info.setRoles(n);
            info.setRole(u.getUsername());
            info.setName(u.getUsername());
            map.put("data",info);
        }
        return map;
    }
}
