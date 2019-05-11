package com.neu.yang.dto;

public class CommentSelected {
    private String userName;
    private Integer goodsId;
    private Integer evaluate;

    public CommentSelected() {
    }

    public CommentSelected(String userName, Integer goodsId, Integer evaluate) {
        this.userName = userName;
        this.goodsId = goodsId;
        this.evaluate = evaluate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
