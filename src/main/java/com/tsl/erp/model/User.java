package com.tsl.erp.model;

import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:40
 * @Description:
 */

public class User {

    private Integer uId; // 用戶id

    private String userName; // 用戶名

    private String password; // 用戶密碼

    private String locked; // 用戶鎖定狀態

    private Set<Role> roles; // 角色名

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User[" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                ", roles=" + roles +
                ']';
    }
}
