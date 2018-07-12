package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018-07-12.
 */
public class SysRole {

    private Integer id;
    private String roleName;
    private String roleTag;

    public SysRole() {
    }

    public SysRole(Integer id, String roleName, String roleTag) {
        this.id = id;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }
}
