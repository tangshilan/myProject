package com.tsl.erp.controller.sysManager;

import com.tsl.erp.model.Role;
import com.tsl.erp.service.RoleService;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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

    @RequestMapping("/find")
    public String find(){
        return "sysManager/role_list";
    }

    @RequestMapping("/add")
    public String addRole(){
        return "sysManager/role_add";
    }

    @RequestMapping("/edit")
    public String editRole(){
        return "sysManager/role_edit";
    }

    @RequestMapping("/permission")
    public String permissionRole(){
        return "sysManager/role_permission";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows ) throws Exception{
        EUDataGridResult result = roleService.findAllRole(page,rows);
        return result;
    }

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

    @RequestMapping("/updateAllRole")
    @ResponseBody
    public CustomResult updateAllRole(@Valid Role role, BindingResult bindingResult) throws Exception{
        System.out.println("====== " + role.toString());
        if (bindingResult.hasErrors()){
            return CustomResult.build(101,"修改信息角色失败");
        } else  if (roleService.findByRoleName(role.getRole()) != null){
            return CustomResult.build(101,"该角色信息已存在");
        } else {
            return roleService.modifyRole(role);
        }
    }
}
