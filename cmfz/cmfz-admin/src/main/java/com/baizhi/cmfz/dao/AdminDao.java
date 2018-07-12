package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018-07-04.
 */

public interface AdminDao {


    //根据姓名找管理员
    public Admin selectAdmin(String name);

    //插入管理员
    public Integer insertAdmin(Admin admin);

    //修改管理员
    public Integer updateAdmin(Admin admin);

}
