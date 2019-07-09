package com.tsl.erp.model;

import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:40
 * @Description:
 */

public class User {

    @Size(max=36, message="用户编号过长！")
    private Integer uId; // 用戶id

    @Size(max=64, message="用户名过长！")
    private String userName; // 用戶名

    @Size(max=32, message="密码过长！")
    private String password; // 用戶密碼

    @Size(max=1, message="用户状态输入非法！")
    private String locked; // 用戶鎖定狀態

    @Size(max=128, message="角色名过长！")
    private Role roles; // 角色名

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

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User[" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                ", roles=" + roles.getRole() +
                ']';
    }
}
