package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    //查身份
    List<SysRole> findRolesBuUsername(String username);

    //查所有的操作权限
    List<SysPermission> findPermissionsByUsername(String username);



}
