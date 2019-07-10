package com.tsl.erp.model;

import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:40
 * @Description:
 */

public class Role {

    private Integer rId; // 角色id

    private String role; // 角色名稱

    private String available; // 是否有效

    private String permission; // 权限

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Role[" +
                "rId='" + rId + '\'' +
                ", role='" + role + '\'' +
                ", available='" + available + '\'' +
                ", permission=" + permission +
                ']';
    }
}
