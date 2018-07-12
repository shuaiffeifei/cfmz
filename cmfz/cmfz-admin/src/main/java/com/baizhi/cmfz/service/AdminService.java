package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;

import java.util.List;

/**
 * Created by Administrator on 2018-07-04.
 */
public interface AdminService {

    //管理员登录 (普通加盐认证)
    public Admin adminLogin(String name,String password);

    //管理员登录(Shiro安全认证)
    public Admin adminLoginByShiro(String name);

    //管理员注册
    public Integer adminRegist(Admin admin);

    //管理员修改信息
    public Integer adminModify(Admin admin);

    List<SysRole> queryRolesByUsername(String username);

    List<SysPermission> queryPermissionByUsername(String username);


}
