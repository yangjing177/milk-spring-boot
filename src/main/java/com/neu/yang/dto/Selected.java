package com.neu.yang.dto;

public class Selected {
    private String brand;
    private String type;
    private String packager;
    private String size;

    public Selected() {
    }

    public Selected(String brand, String type, String packager, String size) {
        this.brand = brand;
        this.type = type;
        this.packager = packager;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPackager() {
        return packager;
    }

    public void setPackager(String packager) {
        this.packager = packager;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
