package com.tsl.erp.service.imp;

import com.tsl.erp.dao.RolePermissionDao;
import com.tsl.erp.model.RolePermission;
import com.tsl.erp.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:43
 * @Description:
 */
@Service
public class PermissionServiceImp implements PermissionService {

    @Autowired
    RolePermissionDao rolePermissionDao;

    @Override
    public RolePermission findRolePermissionByRId(Integer rId) {
        return rolePermissionDao.selectRolePermissionByRId(rId);
    }
}
