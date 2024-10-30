package com.example.mtc;

public class sp_yt_LBaiViet {
    private int resouceId;
    private String tittle, type;

    public sp_yt_LBaiViet(int resouceId, String tittle, String type) {
        this.resouceId = resouceId;
        this.tittle = tittle;
        this.type = type;
    }

    public int getResouceId() {
        return resouceId;
    }

    public void setResouceId(int resouceId) {
        this.resouceId = resouceId;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
