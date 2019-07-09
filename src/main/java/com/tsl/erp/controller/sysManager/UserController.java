package com.tsl.erp.controller.sysManager;

import com.tsl.erp.model.User;
import com.tsl.erp.model.UserData;
import com.tsl.erp.service.UserService;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 14:06
 * @Description:
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/find")
    public String find(){
        return "sysManager/user_list";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EUDataGridResult getList(Integer page, Integer rows) throws Exception{
        EUDataGridResult result = userService.findAllByUser(page, rows);
        return result;
    }

    @RequestMapping("/role")
    public String userRole() throws Exception{
        return "sysManager/user_role_edit";
    }

    @RequestMapping("/add")
    public String add() throws Exception{
        return "sysManager/user_add";
    }

    @RequestMapping("/edit")
    public String edit() throws Exception{
        return "sysManager/user_edit";
    }

    @RequestMapping(value="/insert", method= RequestMethod.POST)
    @ResponseBody
    private CustomResult insert(@Valid UserData user, BindingResult bindingResult){
        System.out.println("===== " + user.toString());
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }

        if(userService.findUserByNameAndId(user.getUserName(), user.getuId()) != null){
            return CustomResult.build(101, "该用户名已经存在，请更换用户名!");
        }else if(userService.findUserById(user.getuId()) != null){
            return CustomResult.build(101, "该用户编号已经存在，请更换用户编号！");
        }
        result = userService.addUser(user);
        return  result;
    }

    @RequestMapping(value="/update_all")
    @ResponseBody
    private CustomResult updateAll(@Valid UserData user, BindingResult bindingResult) throws Exception {
        System.out.println("====  "+ user.toString());
        CustomResult result;
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            return CustomResult.build(100, fieldError.getDefaultMessage());
        }
        if(userService.findUserByNameAndId(user.getUserName(), user.getuId()) != null){
            return CustomResult.build(101, "该用户名已经存在，请更换用户名！");
        }
        result = userService.modifyAllById(user);
        return result;
    }

    @RequestMapping(value="/delete_batch")
    @ResponseBody
    private CustomResult deleteBatch(String[] ids) throws Exception {
        CustomResult result = userService.deleteBatch(ids);
        return result;
    }
}
