package com.baizhi.cmfz.utils;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2018-07-11.
 */
public class MyRealm extends AuthorizingRealm {

  /*  @Autowired
    private AdminDao adminDao;*/

    @Autowired
    private AdminService adminService;

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
        List<SysRole> sysRoles = adminService.queryRolesByUsername(username);
        //封装查询到的授权信息对象
         SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        for (SysRole sysRole : sysRoles) {
            info.addRole(sysRole.getRoleName());
        }
        List<SysPermission> permissions=adminService.queryPermissionByUsername(username);
        for (SysPermission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
}
    /**
     * 获取认证信息方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入验证！！！！！");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Admin admin = adminService.adminLoginByShiro(username);
        if (admin != null) {
            if (admin.getMgr_name().equals(username)) {
                return new SimpleAuthenticationInfo(username, admin.getMgr_pwd(), ByteSource.Util.bytes(admin.getSalt())
                        , UUIDUtils.getUUID());
            }
        }
        return null;
    }
}
