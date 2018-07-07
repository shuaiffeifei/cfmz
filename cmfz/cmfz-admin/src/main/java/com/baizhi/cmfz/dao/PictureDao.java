package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-07-05.
 */
public interface PictureDao {

    //分页查询图片
    public List<Picture> selectAllPicByPage(@Param("begin")Integer begin,@Param("end")Integer end);

    //图片的增加
    public Integer insertPic(Picture picture);

    //图片的修改
    public Integer modifyPic(Picture picture);

    //图片的删除
    public Integer deletePic(String id);

    //查询总条数
    public Integer count();

}
