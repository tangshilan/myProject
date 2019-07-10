package com.tsl.erp.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsl.erp.dao.PermissionsDao;
import com.tsl.erp.dao.RoleDao;
import com.tsl.erp.model.Role;
import com.tsl.erp.service.RoleService;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:43
 * @Description:
 */
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleDao roleDao;
    @Autowired
    PermissionsDao permissionsDao;

    @Override
    public Role findByRoleId(Integer rId) {
        return roleDao.selectByRoleId(rId);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleDao.selectByRoleName(roleName);
    }

    @Override
    public EUDataGridResult findAllRole(int page, int size) {
        PageHelper.startPage(page,size);
        EUDataGridResult euDataGridResult = new EUDataGridResult();

        List<Role> roles = roleDao.selectAllRole();
        euDataGridResult.setRows(roles);

        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        euDataGridResult.setTotal(pageInfo.getTotal());

        return euDataGridResult;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.selectAllRole();
    }

    @Override
    public CustomResult modifyRole(Role role) {

        int modifyRolrResult = roleDao.updateRole(role);
        int modifyRolePermisssionResult = permissionsDao.updateRolePermissionByRole(role.getrId(),role.getPermission());

        if (modifyRolrResult < 0 || modifyRolePermisssionResult < 0){
            return CustomResult.build(101,"修改角色信息失败");
        }
        return CustomResult.build(200,"修改角色信息成功");
    }


}
