package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-07.
 */
public interface MasterService {

    //查询上师
    public List<Master> queryAllMasters();

    //分页展示所有的上师
    public Map<String,Object> queryAllMasterByPage(Integer nowPage, Integer pageSize);

    //模糊查询所有的上师
    public Map<String,Object> queryAllMasterByLike(Integer nowPage, Integer pageSize,String value);

    //添加上师
    public Integer addMaster(Master pic);

    //修改上师
    public Integer modifyMaster(Master pic);

    //删除上师
    public Integer dropMaster( Integer id);

}
