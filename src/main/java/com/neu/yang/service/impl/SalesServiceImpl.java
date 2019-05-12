package com.neu.yang.service.impl;

import com.neu.yang.mapper.SalesMapper;
import com.neu.yang.model.Sales;
import com.neu.yang.service.SalesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SalesServiceImpl implements SalesService {

    @Resource
    private SalesMapper salesMapper;

    /**
     * 添加
     * @param sales
     */
    public void save(Sales sales){
        salesMapper.insert(sales);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        salesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param sales
     */
    public void update(Sales sales){
        salesMapper.updateByPrimaryKey(sales);
    }

    /**
     * 查询所有
     * @return
     */
    public List<Sales> findAll(){
        return salesMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Sales findById(Integer id){
        return salesMapper.selectByPrimaryKey(id);
    }
}
