package com.tsl.erp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: Administrator
 * @Date: 2019/7/6 10:48
 * @Description:
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/unAuth")
    public String unAtuh(){
        return "unAuth";
    }

    @PostMapping("/login")
    public String login(String username, String password, boolean rememberMe,Model model){
        System.out.println("******" + rememberMe);
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e){
            System.out.println("账户不存在");
            model.addAttribute("msg","账户不存在");
            return "login";
        } catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            model.addAttribute("msg","密码错误");
            return "login";
        }
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
