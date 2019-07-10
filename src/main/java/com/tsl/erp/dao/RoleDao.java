package com.tsl.erp.dao;

import com.tsl.erp.model.Role;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:41
 * @Description:
 */

public interface RoleDao {

     Role selectByRoleId(Integer id);

     Role selectByRoleName(String roleName);

     List<Role> selectAllRole();

     int updateRole(Role role);

}
