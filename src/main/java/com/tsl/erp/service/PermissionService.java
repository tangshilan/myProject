package com.tsl.erp.service;

import com.tsl.erp.model.Permission;
import com.tsl.erp.model.RolePermission;
import com.tsl.erp.util.CustomResult;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface PermissionService {
    RolePermission findRolePermissionByRId(Integer rId);
    List<Permission> findPermission(Integer rId);

    CustomResult modifyRolePermissionByRole(Integer rId, String permission);
}
