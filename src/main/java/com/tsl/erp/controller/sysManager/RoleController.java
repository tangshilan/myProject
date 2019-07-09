package com.tsl.erp.controller.sysManager;

import com.tsl.erp.model.Role;
import com.tsl.erp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 14:06
 * @Description:
 */

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("/get/{roleId}")
    @ResponseBody
    public Role getItemById(@PathVariable Integer roleId){
        Role role = roleService.findByRoleId(roleId);
        return role;
    }

    @RequestMapping("/get_data")
    @ResponseBody
    public List<Role> getData() throws Exception{
        return roleService.findAllRole();
    }
}
