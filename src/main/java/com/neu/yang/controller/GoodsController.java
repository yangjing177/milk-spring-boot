package com.neu.yang.controller;


import com.neu.yang.dto.Selected;
import com.neu.yang.entity.Update;
import com.neu.yang.model.Goods;
import com.neu.yang.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsServiceImpl goodsService;

    @ResponseBody
    @PostMapping("/list")
    public List<Goods> getList(@RequestBody Selected selected) {
        List<Goods> list=goodsService.screenGoods(selected);
        return list;
    }

    @ResponseBody
    @GetMapping("/table")
    public Map<String, Object> getList() {
        return goodsService.findAll();
    }

    @ResponseBody
    @PostMapping("update")
    public Map<String, Object> update(@RequestBody Goods goods) {
        goodsService.update(goods);
        return goodsService.findAll();
    }

    @ResponseBody
    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Goods goods) {
        goods.setIsDeleted(1    );
        goodsService.update(goods);
        return goodsService.findAll();
    }
}
