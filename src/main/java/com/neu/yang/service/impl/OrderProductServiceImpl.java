package com.neu.yang.service.impl;

import com.neu.yang.mapper.GoodsMapper;
import com.neu.yang.mapper.SalesMapper;
import com.neu.yang.model.Car;
import com.neu.yang.model.Goods;
import com.neu.yang.model.Sales;
import com.neu.yang.service.GoodsService;
import com.neu.yang.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private SalesMapper salesMapper;

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

    @Override
    public int insertOrderProduct(String orderNum, List<Car> cars) {
        OrderProduct orderProduct=new OrderProduct();
         for(int i=0;i<cars.size();i++){
             //插入订单详情表
           orderProduct.setOrderNumber(orderNum);
           orderProduct.setGoodsId(cars.get(i).getGoodsId());
           orderProduct.setGoodsName(cars.get(i).getGoodsName());
           orderProduct.setPrice(cars.get(i).getPrice());
           orderProduct.setFirstDate(cars.get(i).getFirstDate());
           orderProduct.setLastDate(cars.get(i).getLastDate());
           orderProduct.setNumber(cars.get(i).getNumber());
           orderProduct.setTotal(cars.get(i).getTotal());
           orderProduct.setTotalPrice(cars.get(i).getTotalPrice());
           orderProduct.setIsDeleted(0);
           orderproductMapper.insert(orderProduct);

           //减少库存，插入销量表
             Goods goods=goodsMapper.selectByPrimaryKey(cars.get(i).getGoodsId());
             int number=goods.getNumber()-cars.get(i).getTotal();
             goods.setNumber(number);
             goodsMapper.updateByPrimaryKey(goods);


             Sales sales=new Sales();
             int total=cars.get(i).getTotal();
             float totalPrice=cars.get(i).getTotalPrice();
             sales= salesMapper.queryByGoodId(cars.get(i).getGoodsId());
             if(sales!=null){
                 total+=sales.getTotal();
                 totalPrice+=sales.getTotalPrice();
                 sales.setTotal(total);
                 sales.setTotalPrice(totalPrice);
                 salesMapper.updateByPrimaryKey(sales);
             }
             else {
                 Sales salesTwo=new Sales();
                 salesTwo.setGoodsId(cars.get(i).getGoodsId());
                 salesTwo.setGoodsName(cars.get(i).getGoodsName());
                 salesTwo.setTotal(total);
                 salesTwo.setTotalPrice(totalPrice);
                 salesTwo.setIsDeleted(0);
                 salesMapper.insert(salesTwo);
             }
         }
         return 1;
    }

    @Override
    public List<OrderProduct> queryOrderProduct(String orderNumber) {
        return orderproductMapper.queryOrderProduct(orderNumber);
    }
}
