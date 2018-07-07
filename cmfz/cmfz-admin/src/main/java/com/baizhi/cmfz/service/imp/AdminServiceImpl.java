package com.baizhi.cmfz.service.imp;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import com.baizhi.cmfz.utils.Getsolt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018-07-04.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin adminLogin(String name, String password) {
        Admin admin= adminDao.selectAdmin(name);
        if(admin!=null){
            String salt=admin.getSalt();
            String pwd2;
            try {
                pwd2 = Getsolt.encryption(salt+password);
                if(pwd2.equals(admin.getMgr_pwd())){
                    return admin;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //管理员注册
    public Integer adminRegist(Admin admin) {
        Integer result=0;
        try {
            String salt=Getsolt.getRandomSalt(6);
            String newpwd=Getsolt.encryption(salt+admin.getMgr_pwd());
            admin.setMgr_pwd(newpwd);
            admin.setSalt(salt);
            admin.setStatus("0");
            result=adminDao.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //管理员修改信息
    public Integer adminModify(Admin admin) {

        Integer result=0;

        try{
            String salt=Getsolt.getRandomSalt(6);
            String newpwd=Getsolt.encryption(salt+admin.getMgr_pwd());
            admin.setMgr_pwd(newpwd);
            admin.setSalt(salt);
            result=adminDao.updateAdmin(admin);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
