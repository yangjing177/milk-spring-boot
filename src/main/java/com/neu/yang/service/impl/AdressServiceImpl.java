package com.neu.yang.service.impl;

import com.neu.yang.service.AdressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

import com.neu.yang.model.Adress;
import com.neu.yang.mapper.AdressMapper;

@Service
@Transactional
public class AdressServiceImpl implements AdressService {

    @Resource
    private AdressMapper adressMapper;

    /**
     * 添加
     * @param adress
     */
    public void save(Adress adress){
        adressMapper.insert(adress);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        adressMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param adress
     */
    public void update(Adress adress){
        adressMapper.updateByPrimaryKey(adress);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Adress> findAll(){
        return adressMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Adress findById(Integer id){
        return adressMapper.selectByPrimaryKey(id);
    }

    public List<Adress> findAdress(String user){
        List<Adress> list=adressMapper.findAdress(user);
        return list;
    }
}
