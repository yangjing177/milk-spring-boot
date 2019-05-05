package com.neu.yang.service.impl;

import com.neu.yang.dto.Selected;
import com.neu.yang.entity.Person;
import com.neu.yang.mapper.GoodsMapper;
import com.neu.yang.model.Goods;
import com.neu.yang.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 添加
     * @param goods
     */
    public void save(Goods goods){
        goodsMapper.insert(goods);
    }

    /**
     * 主键删除
     * @param id
     */
    public void delete(Integer id){
        goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改
     * @param goods
     */
    public void update(Goods goods){
        goodsMapper.updateByPrimaryKey(goods);
    }

    /**
     * 查询所有
     * @return
     */
//    public List<Goods> findAll(){
//        return goodsMapper.selectAll();
//    }
    /**
     * 查询
     * @return
     */
    public Goods findById(Integer id){
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> screenGoods(Selected selected) {
        if(selected.getType().equals("不限")){
            selected.setType("");
        }
        if(selected.getPackager().equals("不限")){
            selected.setPackager("");
        }
        if(selected.getSize().equals("不限")){
            selected.setSize("");
        }
        else if (selected.getSize().equals("小于299")){
            selected.setSize("299");
        }
        else if (selected.getSize().equals("300至499")){
            selected.setSize("499");
        }
        else if (selected.getSize().equals("大于500")){
            selected.setSize("500");
        }
        List<Goods> list=goodsMapper.screenGoods(selected);
        return list;
    }

    @Override
    public Map<String, Object> findAll() {
        List<Goods> list=goodsMapper.findAll();
        Map<String,Object> map=new HashMap<>();
        int totalRow=list.size();
        int code=20000;
        map.put("code",code);
        map.put("data",list);
        map.put("totalRow",totalRow);
        return map;
    }
}
