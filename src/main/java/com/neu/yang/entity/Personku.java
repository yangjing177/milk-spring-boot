package com.neu.yang.entity;

import java.sql.Date;

public class Personku {
    private Integer uid;
    private String cname;
    private String title;
    private Integer number;
    private Date date;
    private Integer num;
    private Integer price;

    public Personku() {
    }

    public Personku(Integer uid, String cname, String title, Integer number, Date date, Integer num, Integer price) {
        this.uid = uid;
        this.cname = cname;
        this.title = title;
        this.number = number;
        this.date = date;
        this.num = num;
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
