package com.neu.yang.controller;


import com.neu.yang.dto.Selected;
import com.neu.yang.model.Goods;
import com.neu.yang.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsServiceImpl goodsService;

    @ResponseBody
    @PostMapping("/list")
    public List<Goods> getList(@RequestBody Selected selected) {
        return goodsService.screenGoods(selected);
    }
}
