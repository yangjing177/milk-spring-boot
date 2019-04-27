package com.neu.yang.service.impl;

import com.neu.yang.service.OrderProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

import com.neu.yang.model.OrderProduct;
import com.neu.yang.mapper.OrderProductMapper;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    @Resource
    private OrderProductMapper orderproductMapper;

    /**
     * 添加
     * @param orderproduct
     */
    public void save(OrderProduct orderproduct){
        orderproductMapper.insert(orderproduct);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        orderproductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param orderproduct
     */
    public void update(OrderProduct orderproduct){
        orderproductMapper.updateByPrimaryKey(orderproduct);
    }

    /**
     * 查询所有
     * @return
     */
    public List<OrderProduct> findAll(){
        return orderproductMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public OrderProduct findById(Integer id){
        return orderproductMapper.selectByPrimaryKey(id);
    }
}
