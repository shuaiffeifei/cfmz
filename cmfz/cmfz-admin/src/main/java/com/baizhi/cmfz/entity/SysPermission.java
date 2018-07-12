package com.baizhi.cmfz.entity;

/**
 * Created by Administrator on 2018-07-12.
 */
public class SysPermission {
    private Integer id;
    private String  resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    public SysPermission() {
    }

    public SysPermission(Integer id, String resourceName, String resourceTag, String resourceUrl, String permissionTag) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permissionTag = permissionTag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }
}
