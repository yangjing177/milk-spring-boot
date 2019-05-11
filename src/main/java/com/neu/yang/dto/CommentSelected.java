package com.neu.yang.dto;

public class CommentSelected {
    private String userName;
    private Integer evaluate;

    public CommentSelected() {
    }

    public CommentSelected(String userName, Integer evaluate) {
        this.userName = userName;
        this.evaluate = evaluate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }
}
