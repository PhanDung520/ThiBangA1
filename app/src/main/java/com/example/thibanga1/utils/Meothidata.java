package com.example.thibanga1.utils;

public class Meothidata {
    private String tvTitle;
    private String tvContent;

    public Meothidata() {
    }

    public Meothidata(String tvTitle, String tvContent) {
        this.tvTitle = tvTitle;
        this.tvContent = tvContent;
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
