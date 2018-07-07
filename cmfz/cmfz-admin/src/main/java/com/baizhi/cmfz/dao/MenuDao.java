package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-07-05.
 */
public interface MenuDao {


    //查询所有一级分类
    public List<Menu> selectAllParent();

    //查询所有二级分类
    public List<Menu> selectSons();


}
