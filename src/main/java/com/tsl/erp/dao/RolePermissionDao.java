package com.tsl.erp.dao;

import com.tsl.erp.model.RolePermission;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:41
 * @Description:
 */

public interface RolePermissionDao {
    RolePermission selectRolePermissionByRId(Integer rId);
}
