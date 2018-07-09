package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-07-09.
 */
public interface LogDao {

    //查所有的日志
    public List<Log> selectAlllogsByPage(@Param("begin") Integer begin,@Param("end") Integer end);

    //插入日志
    public Integer insertlog(Log log);

    //删除日志
    public Integer deletelog(String id);
}
