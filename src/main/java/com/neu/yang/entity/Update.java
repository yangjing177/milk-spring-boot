package com.neu.yang.entity;

import java.sql.Date;

public class Update {
    private int uid;
    private String cname;
    private Date date;
    private int status;

    public Update() {
    }

    public Update(int uid, String cname, Date date, int status) {
        this.uid = uid;
        this.cname = cname;
        this.date = date;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
