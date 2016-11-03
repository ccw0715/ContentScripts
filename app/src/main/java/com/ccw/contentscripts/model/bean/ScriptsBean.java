package com.ccw.contentscripts.model.bean;

/**
 * Created by 蔡灿武 on 2016/11/2 0002.
 */

public class ScriptsBean {
    private String label;
    private String avatar_url;
    private String name;
    private String content;
    private String category_name;
    private int digg_count;
    private int bury_count;
    private int comment_count;
    private int share_count;

    public ScriptsBean() {
    }

    public ScriptsBean(String label,String avatar_url, String name, String content, String category_name, int digg_count, int bury_count, int comment_count, int share_count) {
        this.label = label;
        this.avatar_url = avatar_url;
        this.name = name;
        this.content = content;
        this.category_name = category_name;
        this.digg_count = digg_count;
        this.bury_count = bury_count;
        this.comment_count = comment_count;
        this.share_count = share_count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getBury_count() {
        return bury_count;
    }

    public void setBury_count(int bury_count) {
        this.bury_count = bury_count;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }

    @Override
    public String toString() {
        return "ScriptsBean{" +
                "label='" + label + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", category_name='" + category_name + '\'' +
                ", digg_count=" + digg_count +
                ", bury_count=" + bury_count +
                ", comment_count=" + comment_count +
                ", share_count=" + share_count +
                '}';
    }
}
