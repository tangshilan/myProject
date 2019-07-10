package com.tsl.erp.service;

import com.tsl.erp.model.Role;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface RoleService {

    Role findByRoleId(Integer rId);
    public Role findByRoleName(String roleName);

    EUDataGridResult findAllRole(int page, int size);

    List<Role> findAllRole();

    CustomResult modifyRole(Role role);

}
