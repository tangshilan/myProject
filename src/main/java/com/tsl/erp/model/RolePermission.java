package com.tsl.erp.model;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 18:04
 * @Description:
 */

public class RolePermission {
    private String id;

    private String roleId;

    private String permissionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermission[" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ']';
    }
}
