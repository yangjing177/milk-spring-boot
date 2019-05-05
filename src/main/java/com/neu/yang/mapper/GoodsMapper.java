package com.neu.yang.mapper;

import com.neu.yang.dto.Selected;
import com.neu.yang.model.Goods;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface GoodsMapper extends Mapper<Goods> {
    List<Goods> screenGoods(Selected selected);
    List<Goods> findAll();
}
