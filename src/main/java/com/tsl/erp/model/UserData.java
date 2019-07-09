package com.tsl.erp.model;

import javax.validation.constraints.Size;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 17:03
 * @Description:
 */

public class UserData {
    private Integer uId; // 用戶id

    @Size(max=64, message="用户名过长！")
    private String userName; // 用戶名

    @Size(max=32, message="密码过长！")
    private String password; // 用戶密碼

    @Size(max=1, message="用户状态输入非法！")
    private String locked; // 用戶鎖定狀態

    @Size(max=128, message="角色名过长！")
    private String roleName; // 角色名

    private Integer rId; // 角色ID

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "uId=" + uId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", locked='" + locked + '\'' +
                ", roleName='" + roleName + '\'' +
                ", rId=" + rId +
                '}';
    }
}
