package com.neu.yang.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

//@Entity
public class Book {
//    @Id
//    @GeneratedValue
private Integer id;
private String bname;
private String author;
private String sex;
private String gift;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
private String pic;

    public Book() {
    }

    public Book(Integer id, String bname, String author, String sex, String gift, Date time, String pic) {
        this.id = id;
        this.bname = bname;
        this.author = author;
        this.sex = sex;
        this.gift = gift;
        this.time = time;
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
