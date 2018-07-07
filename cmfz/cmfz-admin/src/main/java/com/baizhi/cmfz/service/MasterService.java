package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-07.
 */
public interface MasterService {

    //分页展示所有的图片
    public Map<String,Object> queryAllMasterByPage(Integer nowPage, Integer pageSize);

    public Map<String,Object> queryAllMasterByLike(Integer nowPage, Integer pageSize,String value);
    //添加图片
    public Integer addMaster(Master pic);

    //修改图片
    public Integer modifyMaster(Master pic);

    //删除图片
    public Integer dropMaster( Integer id);

}
