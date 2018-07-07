package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018-07-05.
 */
public class Menu implements Serializable{
    private String id;
    private String menu_name;
    private String menu_code;
    private String menu_icon;
    private String menu_url;
    private String menu_level;
    private String menu_parent_id;
    private List<Menu> lists;

    public Menu() {
    }

    public Menu(String id, String menu_name, String menu_code, String menu_icon, String menu_url, String menu_level, String menu_parent_id, List<Menu> lists) {
        this.id = id;
        this.menu_name = menu_name;
        this.menu_code = menu_code;
        this.menu_icon = menu_icon;
        this.menu_url = menu_url;
        this.menu_level = menu_level;
        this.menu_parent_id = menu_parent_id;
        this.lists = lists;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_code() {
        return menu_code;
    }

    public void setMenu_code(String menu_code) {
        this.menu_code = menu_code;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public String getMenu_level() {
        return menu_level;
    }

    public void setMenu_level(String menu_level) {
        this.menu_level = menu_level;
    }

    public String getMenu_parent_id() {
        return menu_parent_id;
    }

    public void setMenu_parent_id(String menu_parent_id) {
        this.menu_parent_id = menu_parent_id;
    }

    public List<Menu> getLists() {
        return lists;
    }

    public void setLists(List<Menu> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", menu_name='" + menu_name + '\'' +
                ", menu_code='" + menu_code + '\'' +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_url='" + menu_url + '\'' +
                ", menu_level='" + menu_level + '\'' +
                ", menu_parent_id='" + menu_parent_id + '\'' +
                ", lists=" + lists +
                '}';
    }
}
