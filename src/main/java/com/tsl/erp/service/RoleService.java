package com.tsl.erp.service;

import com.tsl.erp.model.Role;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface RoleService {

    Role findByRoleId(Integer rId);
    List<Role> findAllRole();
}
