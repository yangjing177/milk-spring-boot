package com.neu.yang.service.impl;

import com.neu.yang.model.Goods;
import com.neu.yang.service.OrderInfoService;
import com.neu.yang.util.OrderNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//    public List<OrderInfo> findAll(){
//        return orderinfoMapper.selectAll();
//    }
    /**
     * 查询
     * @return
     */
    public OrderInfo findById(Integer id){
        return orderinfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public String insertOrderInfo(OrderInfo orderInfo) {
        OrderNumber orderNumber=new OrderNumber();
        String orderNum=orderNumber.getOrderNo();
        orderInfo.setOrderNumber(orderNum);
        orderInfo.setCreateDate(new Date());
        orderInfo.setUpdateDate(new Date());
        int num= orderinfoMapper.insert(orderInfo);
        return orderNum;
    }

    @Override
    public List<OrderInfo> findOrderInfo(String orderStatus,String user){
        List<OrderInfo> list=orderinfoMapper.findOrderInfo(orderStatus,user);
        return list;
    }

    @Override
    public Map<String, Object> findAll() {
        List<OrderInfo> list=orderinfoMapper.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=list.size();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }
}
