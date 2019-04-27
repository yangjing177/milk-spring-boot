package com.neu.yang.service.impl;

import com.neu.yang.service.OrderInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

import com.neu.yang.model.OrderInfo;
import com.neu.yang.mapper.OrderInfoMapper;

@Service
@Transactional
public class OrderInfoServiceImpl implements OrderInfoService {

    @Resource
    private OrderInfoMapper orderinfoMapper;

    /**
     * 添加
     * @param orderinfo
     */
    public void save(OrderInfo orderinfo){
        orderinfoMapper.insert(orderinfo);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        orderinfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param orderinfo
     */
    public void update(OrderInfo orderinfo){
        orderinfoMapper.updateByPrimaryKey(orderinfo);
    }

    /**
     * 查询所有
     * @return
     */
    public List<OrderInfo> findAll(){
        return orderinfoMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public OrderInfo findById(Integer id){
        return orderinfoMapper.selectByPrimaryKey(id);
    }
}
