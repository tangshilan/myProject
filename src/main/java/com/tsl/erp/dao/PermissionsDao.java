package com.tsl.erp.dao;

import com.tsl.erp.model.Permission;
import com.tsl.erp.model.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/9 22:06
 * @Description:
 */

public interface PermissionsDao {
    RolePermission selectRolePermissionByRId(Integer rId);
    List<Permission> selectPermission(Integer rId);

    int updateRolePermissionByRole(@Param("rId") Integer rId, @Param("permission") String permission);
}
