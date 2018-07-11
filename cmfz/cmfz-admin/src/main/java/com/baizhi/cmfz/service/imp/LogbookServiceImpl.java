package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018-07-09.
 */
@Service
public class LogbookServiceImpl implements LogbookService{

    @Autowired
    private LogDao logDao;


    @Override
    public Map<String, Object> findAllLogsByPage(Integer nowPage, Integer pageSize) {
        List<Log> logs = logDao.selectAlllogsByPage((nowPage - 1) * pageSize, pageSize);
        Integer count = logDao.count();
        //初始化map集合
        Map<String,Object>map=new HashMap<>();
        map.put("total",count);
        map.put("rows",logs);
        return map;
    }

    @Override
    public Integer addLog(Log log) {
        return logDao.insertlog(log);
    }

    @Override
    public Integer deleteLog(String id) {
        return logDao.deletelog(id);
    }
}
