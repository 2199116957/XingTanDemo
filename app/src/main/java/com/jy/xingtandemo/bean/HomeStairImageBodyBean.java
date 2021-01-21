package com.jy.xingtandemo.bean;

public class HomeStairImageBodyBean {
    private String categoryId1;
    private String categoryId2;
    private String type;

    @Override
    public String toString() {
        return "HomeStairImageBodyBean{" +
                "categoryId1='" + categoryId1 + '\'' +
                ", categoryId2='" + categoryId2 + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getCategoryId1() {
        return categoryId1;
    }

    public void setCategoryId1(String categoryId1) {
        this.categoryId1 = categoryId1;
    }

    public String getCategoryId2() {
        return categoryId2;
    }

    public void setCategoryId2(String categoryId2) {
        this.categoryId2 = categoryId2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
