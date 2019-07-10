package com.tsl.erp.controller.sysManager;

import com.tsl.erp.model.RolePermission;
import com.tsl.erp.service.PermissionService;
import com.tsl.erp.util.CustomResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 18:06
 * @Description:
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("/get_permission")
    @ResponseBody
    public RolePermission getPermission(String rId){
        System.out.println("========= getPermission " + rId);
        RolePermission rolePermission = permissionService.findRolePermissionByRId(Integer.valueOf(rId));

        System.out.println("========  " + rolePermission.toString());
        return rolePermission;
    }

    @RequestMapping("/update_by_roleid")
    @ResponseBody
    public CustomResult updatePermissionByRole(String rId,String permission){
        return permissionService.modifyRolePermissionByRole(Integer.valueOf(rId),permission);
    }
}
