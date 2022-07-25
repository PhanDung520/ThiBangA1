package com.example.thibanga1.utils;

public class BienbaoData {

    private String imgBien;
    private String tvTitle;
    private String tvContent;

    public BienbaoData() {
    }

    public BienbaoData(String imgBien, String tvTitle, String tvContent) {
        this.imgBien = imgBien;
        this.tvTitle = tvTitle;
        this.tvContent = tvContent;

    }

    public String getImgBien() {
        return imgBien;
    }

    public void setImgBien(String imgBien) {
        this.imgBien = imgBien;
    }

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvContent() {
        return tvContent;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
    }


}
