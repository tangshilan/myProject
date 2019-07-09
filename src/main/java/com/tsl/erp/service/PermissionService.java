package com.tsl.erp.service;

import com.tsl.erp.model.RolePermission;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface PermissionService {

    RolePermission findRolePermissionByRId(Integer rId);
}
