package com.neu.yang.service.impl;

import com.neu.yang.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

import com.neu.yang.model.Address;
import com.neu.yang.mapper.AddressMapper;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper adressMapper;

    /**
     * 添加
     * @param adress
     */
    public void save(Address adress){
        adressMapper.insert(adress);
    }

    @Override
    public int findMaxId() {
        return adressMapper.findMaxId();
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
     * @param address
     */
    public void update(Address address){
        adressMapper.updateByPrimaryKey(address);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Address> findAll(){
        return adressMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Address findById(Integer id){
        return adressMapper.selectByPrimaryKey(id);
    }

    public List<Address> findAddress(String user){
        List<Address> list=adressMapper.findAddress(user);
        return list;
    }
}
