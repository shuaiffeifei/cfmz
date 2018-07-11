package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.Map;

/**
 * Created by Administrator on 2018-07-09.
 */
public interface LogbookService {


    //查询所有的日志
    public Map<String,Object> findAllLogsByPage(Integer nowPage, Integer pageSize);

    //插入日志
    public Integer addLog(Log log);

    //删除日志
    public Integer deleteLog(String id);

}
