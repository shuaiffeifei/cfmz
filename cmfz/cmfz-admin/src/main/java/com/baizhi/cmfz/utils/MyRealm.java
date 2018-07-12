package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018-07-11.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private AdminDao adminDao;

    /**
     * 获取授权信息方法  角色信息+权限信息
     *
     * 支持三种权限校验方式：
     *      1. 编程式   subject.hasRole hasRoles ...
     *      2. 标签式
     *              标签库
     *      3. 注解式
     *
     * @param principalCollection
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username= (String) principalCollection.getPrimaryPrincipal();
        Admin admin = adminDao.selectAdmin(username);
        if(admin!=null) {
            String mgr_name = admin.getMgr_name();
            if (mgr_name.equals(username)) {
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                info.addRole("root");
                info.addRole("admmin");
                info.addRole("user");

                info.addStringPermission("user:add");
                return info;
            }

        }

        return null;
    }
    /**
     * 获取认证信息方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Admin admin = adminDao.selectAdmin(username);
        if (admin != null) {
            if (admin.getMgr_name().equals(username)) {
                return new SimpleAuthenticationInfo(username, admin.getMgr_pwd(), ByteSource.Util.bytes(admin.getSalt())
                        , UUIDUtils.getUUID());
            }
        }
        return null;
    }
}
