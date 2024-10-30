package com.example.mtc;

public class sp_yt_LSanPham {
    private int resourceId;
    private String name, price;

    public sp_yt_LSanPham(int resourceId, String name, String price) {
        this.resourceId = resourceId;
        this.name = name;
        this.price = price;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
