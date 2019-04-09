package com.neu.yang.entity;

public class Kucun {

    private Integer id;
    private Integer number;
    private Float price;

    public Kucun() {
    }

    public Kucun(Integer id, Integer number, Float price) {
        this.id = id;
        this.number = number;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
