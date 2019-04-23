package com.neu.yang.service.impl;

import com.neu.yang.mapper.CarMapper;
import com.neu.yang.model.Car;
import com.neu.yang.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    /**
     * 添加
     * @param car
     */
    public void save(Car car){
        carMapper.insert(car);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        carMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param car
     */
    public void update(Car car){
        int days=(int) ((car.getLastDate().getTime() - car.getFirstDate().getTime()) / (1000*3600*24))+1;
        int total=days*car.getNumber();
        float totalPrice=total*car.getPrice();
        car.setTotal(total);
        car.setTotalPrice(totalPrice);
        carMapper.updateByPrimaryKey(car);
    }


    /**
     * 查询所有
     * @return
     */
    public List<Car> findAll(){
        List<Car> list=carMapper.selectAll();
        return list;
    }

    /**
     * 查询
     * @return
     */
    public Car findById(Integer id){
        return carMapper.selectByPrimaryKey(id);
    }

    //查询所有
    @Override
    public List<Car> findCars(String user) {
        List<Car> list=carMapper.findCars(user);
        return list;
    }

    //批量删除
    @Override
    public void delAll(String[] ids) {
        int res=carMapper.delAll(ids);
        System.out.println(res);
    }

    @Override
    public List<Car> insert(Car car) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Car> cars=carMapper.findName(car.getUserName(),car.getGoodsName());
        if(!CollectionUtils.isEmpty(cars)){
            int num=car.getNumber()+cars.get(0).getNumber();
            if(num>10){
                num=10;
            }
            car=cars.get(0);
            car.setNumber(num);
            int days=(int) ((car.getLastDate().getTime() - car.getFirstDate().getTime()) / (1000*3600*24))+1;
            int total=days*car.getNumber();
            float totalPrice=total*car.getPrice();
            car.setTotal(total);
            car.setTotalPrice(totalPrice);
            car.setIsDeleted(0);
            carMapper.updateByPrimaryKey(car);
        }
        else {
            if(car.getFirstDate()==null) {
                //获取下个月第一天：
                Calendar first = Calendar.getInstance();
                first.add(Calendar.MONTH, 1);
                first.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
                Date firstDate = first.getTime();

                //获取下个月最后一天
                Calendar last = Calendar.getInstance();
                last.add(Calendar.MONTH, 2);
                last.set(Calendar.DATE, 0);
                Date lastDate = last.getTime();

                car.setFirstDate(firstDate);
                car.setLastDate(lastDate);
            }
                //赋予创建、修改时间
                car.setCreateDate(new Date());
                car.setUpdateDate(new Date());


            int days=(int) ((car.getLastDate().getTime() - car.getFirstDate().getTime()) / (1000*3600*24))+1;
            int total=days*car.getNumber();
            float totalPrice=total*car.getPrice();
            car.setTotal(total);
            car.setTotalPrice(totalPrice);
            car.setIsDeleted(0);
            carMapper.insert(car);
        }
        List<Car> list=carMapper.findName(car.getUserName(),car.getGoodsName());
        return list;
    }

    public int findCarCount(String user){
        int count=carMapper.findCars(user).size();
        return count;
    }
}
