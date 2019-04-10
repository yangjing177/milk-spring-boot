package com.neu.yang.service.impl;

import com.neu.yang.dto.Selected;
import com.neu.yang.model.Goods;
import com.neu.yang.mapper.GoodsMapper;
import com.neu.yang.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Goods> findAll(){
        return goodsMapper.selectAll();
    }
    /**
     * 查询
     * @return
     */
    public Goods findById(Integer id){
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Goods> screenGoods(Selected selected) {
        if(selected.getType().equals("不限")){selected.setType("");};
        if(selected.getPackager().equals("不限")){selected.setPackager("");};
        if(selected.getSize().equals("不限")){selected.setSize("");};
        List<Goods> list=goodsMapper.screenGoods(selected);
        return list;
    }
}
