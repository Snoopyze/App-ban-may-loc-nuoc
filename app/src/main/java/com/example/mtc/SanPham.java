package com.example.mtc;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int resourceID;
    private String tittle, price, content;

    public SanPham(int resourceID, String tittle, String price, String content) {
        this.resourceID = resourceID;
        this.tittle = tittle;
        this.price = price;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
