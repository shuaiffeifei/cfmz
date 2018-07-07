package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-05.
 */
public interface MenuService {


    //展示所有的父级标签
    public List<Menu> showAllParent();

    //展示所有父级标签和所有子标签
    public List<Menu> showAllSons();
}
