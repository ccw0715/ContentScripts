package com.ccw.contentscripts.model.bean;

/**
 * Created by 蔡灿武 on 2016/11/5 0005.
 */

public class VideoBean {
    private String label;
    private String avatar_url;
    private String name;
    private String content;
    private String category_name;
    private int digg_count;
    private int bury_count;
    private int comment_count;
    private int share_count;
    private long id;
    private String videoUrl;
    private String imageUrl;
    private int height;

    public VideoBean() {
    }

    public VideoBean(String label, String avatar_url, String name, String content, String category_name, int digg_count, int bury_count, int comment_count, int share_count, long id, String videoUrl, String imageUrl,int height) {
        this.label = label;
        this.avatar_url = avatar_url;
        this.name = name;
        this.content = content;
        this.category_name = category_name;
        this.digg_count = digg_count;
        this.bury_count = bury_count;
        this.comment_count = comment_count;
        this.share_count = share_count;
        this.id = id;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
