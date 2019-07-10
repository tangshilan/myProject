package com.tsl.erp.service.imp;

import com.tsl.erp.dao.PermissionsDao;
import com.tsl.erp.model.Permission;
import com.tsl.erp.model.RolePermission;
import com.tsl.erp.service.PermissionService;
import com.tsl.erp.util.CustomResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:43
 * @Description:
 */
@Service
public class PermissionServiceImp implements PermissionService {

    @Autowired
    PermissionsDao permissionDao;

    @Override
    public RolePermission findRolePermissionByRId(Integer rId) {
        return permissionDao.selectRolePermissionByRId(rId);
    }

    @Override
    public List<Permission> findPermission(Integer rId) {
        return permissionDao.selectPermission(rId);
    }

    @Override
    public CustomResult modifyRolePermissionByRole(Integer rId, String permission) {
        int result = permissionDao.updateRolePermissionByRole(rId,permission);
        //CustomResult customResult = new CustomResult();
        if (result < 0){
            return CustomResult.build(101,"修改权限信息失败");
        }
        return CustomResult.build(200,"修改权限信息成功");
    }
}
