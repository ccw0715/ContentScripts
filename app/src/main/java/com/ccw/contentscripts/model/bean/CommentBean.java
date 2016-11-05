package com.ccw.contentscripts.model.bean;

/**
 * Created by 蔡灿武 on 2016/11/4 0004.
 */

public class CommentBean {
    private String userFace;
    private String username;
    private int digg_count;
    private String content;

    public CommentBean() {
    }

    public CommentBean(String userFace, String username, int digg_count, String content) {
        this.userFace = userFace;
        this.username = username;
        this.digg_count = digg_count;
        this.content = content;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    @Override
    public String toString() {
        return "CommentBean{" +
                "userFace='" + userFace + '\'' +
                ", username='" + username + '\'' +
                ", digg_count=" + digg_count +
                ", content='" + content + '\'' +
                '}';
    }
}
