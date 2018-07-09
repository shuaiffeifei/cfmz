package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-07-08.
 */
public class Article implements Serializable{
    private String article_id;
    private String article_name;
    private Integer guru_id;
    private String master_name;
    private String introduction;
    private String date;
    private String main_pic;
    private String status;

    public Article() {
    }

    public Article(String article_id, String article_name, Integer guru_id, String master_name, String introduction, String date, String main_pic, String status) {
        this.article_id = article_id;
        this.article_name = article_name;
        this.guru_id = guru_id;
        this.master_name = master_name;
        this.introduction = introduction;
        this.date = date;
        this.main_pic = main_pic;
        this.status = status;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public Integer getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Integer guru_id) {
        this.guru_id = guru_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "article_id='" + article_id + '\'' +
                ", article_name='" + article_name + '\'' +
                ", guru_id=" + guru_id +
                ", master_name='" + master_name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", date='" + date + '\'' +
                ", main_pic='" + main_pic + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
