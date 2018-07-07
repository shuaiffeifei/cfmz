package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Admin;

/**
 * Created by Administrator on 2018-07-04.
 */
public interface AdminService {

    //管理员登录
    public Admin adminLogin(String name,String password);

    //管理员注册
    public Integer adminRegist(Admin admin);

    //管理员修改信息
    public Integer adminModify(Admin admin);


}
