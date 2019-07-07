package com.tsl.erp.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2019/7/6 23:05
 * @Description:
 */

@Controller
public class UserController {

    @RequestMapping("/add")
    public String addUser(){
        return "add";
    }

    @RequestMapping("/update")
    public String updateUser(){
        return "update";
    }
}
