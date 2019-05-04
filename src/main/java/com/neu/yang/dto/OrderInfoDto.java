package com.neu.yang.dto;

public class OrderInfoDto {
    private String user;
    private String orderStatus;

    public OrderInfoDto() {
    }

    public OrderInfoDto(String user, String orderStatus) {
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
