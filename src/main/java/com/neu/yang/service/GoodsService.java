package com.neu.yang.service;

import com.neu.yang.dto.Selected;
import com.neu.yang.model.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> screenGoods(Selected selected);
    Map<String, Object> findAll();
}
