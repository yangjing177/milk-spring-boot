package com.neu.yang.dto;

public class CommentSelected {
    private Integer goodsId;
    private Integer evaluate;

    public CommentSelected() {
    }

    public CommentSelected(Integer goodsId, Integer evaluate) {
        this.goodsId = goodsId;
        this.evaluate = evaluate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }
}
