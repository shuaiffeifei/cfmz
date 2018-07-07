package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-06.
 */
public interface PictureService {


    //分页展示所有的图片
    public Map<String,Object> queryAllPicsByPage(Integer nowPage, Integer pageSize);

    //添加图片
    public Integer addPicture(Picture pic);

    //修改图片
    public Integer modifyPicture(Picture pic);

    //删除图片
    public Integer dropPicture(String id);

}
