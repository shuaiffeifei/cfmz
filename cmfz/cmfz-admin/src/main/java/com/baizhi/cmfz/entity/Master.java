package com.baizhi.cmfz.entity;

import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-07-07.
 */
public class Master implements Serializable {
    @Excel(name = "上师ID")
    private Integer master_id;
    @Excel(name = "上师姓名")
    private String master_name;
    @Excel(name = "上师图片")
    private String master_photo;
    @Excel(name = "上师简介")
    private String master_summar;

    public Master() {
    }

    public Master(Integer master_id, String master_name, String master_photo, String master_summar) {
        this.master_id = master_id;
        this.master_name = master_name;
        this.master_photo = master_photo;
        this.master_summar = master_summar;
    }

    public Integer getMaster_id() {
        return master_id;
    }

    public void setMaster_id(Integer master_id) {
        this.master_id = master_id;
    }

    public String getMaster_name() {
        return master_name;
    }

    public void setMaster_name(String master_name) {
        this.master_name = master_name;
    }

    public String getMaster_photo() {
        return master_photo;
    }

    public void setMaster_photo(String master_photo) {
        this.master_photo = master_photo;
    }

    public String getMaster_summar() {
        return master_summar;
    }

    public void setMaster_summar(String master_summar) {
        this.master_summar = master_summar;
    }

    @Override
    public String toString() {
        return "Master{" +
                "master_id=" + master_id +
                ", master_name='" + master_name + '\'' +
                ", master_photo='" + master_photo + '\'' +
                ", master_summar='" + master_summar + '\'' +
                '}';
    }
}
