package com.example.mtc;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int resourceID;
    private String tittle;
    private String content;
    private int price;
    private String igmPath;

    public SanPham(int resourceID, String tittle, String content, int price, String igmPath) {
        this.resourceID = resourceID;
        this.tittle = tittle;
        this.content = content;
        this.price = price;
        this.igmPath = igmPath;
    }

//    public SanPham(int resourceID, String tittle, String content, int price) {
//        this.resourceID = resourceID;
//        this.tittle = tittle;
//        this.content = content;
//        this.price = price;
//
//    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIgmPath() {
        return igmPath;
    }

    public void setIgmPath(String igmPath) {
        this.igmPath = igmPath;
    }
}
