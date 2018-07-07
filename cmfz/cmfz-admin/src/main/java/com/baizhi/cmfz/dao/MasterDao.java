package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-07-05.
 */
public interface MasterDao {

    //分页查询所有大师
    public List<Master> selectAllMasterByPage(@Param("begin") Integer begin,@Param("end") Integer end);

    //分页模糊查询大师
    public List<Master> selectAllMasterByLike(@Param("begin") Integer begin,@Param("end") Integer end,@Param("value") String value);

    //插入大师
    public Integer insertMaster(Master master);

    //修改大师
    public Integer modifyMaster(Master master);

    //删除大师
    public Integer deleteMaster(Integer id);

    //查询总条数
    public Integer count();

    //查询模糊总条数
    public Integer countByLike(String value);
}
