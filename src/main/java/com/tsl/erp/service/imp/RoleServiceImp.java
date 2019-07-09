package com.tsl.erp.service.imp;

import com.tsl.erp.dao.RoleDao;
import com.tsl.erp.model.Role;
import com.tsl.erp.service.RoleService;
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

    @Override
    public Role findByRoleId(Integer rId) {
        return roleDao.selectByRoleId(rId);
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.selectAllRole();
    }
}
