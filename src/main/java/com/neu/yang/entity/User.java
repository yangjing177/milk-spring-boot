package com.neu.yang.entity;

public class User{
    private Integer id;
    private String uname;
    private String upwd;
    private String type;

    public User() {
    }

    public User(Integer id, String uname, String upwd, String type) {
        this.id = id;
        this.uname = uname;
        this.upwd = upwd;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
