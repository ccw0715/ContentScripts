package com.ccw.contentscripts.model.bean;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class EssenceBean {
    private String keywords;
    private String title;
    private String image_url;

    public EssenceBean() {
    }

    public EssenceBean(String keywords, String title, String image_url) {
        this.keywords = keywords;
        this.title = title;
        this.image_url = image_url;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "EssenceBean{" +
                "keywords='" + keywords + '\'' +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
