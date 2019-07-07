package com.tsl.erp.controller;

import com.google.code.kaptcha.Constants;
import com.tsl.erp.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: Administrator
 * @Date: 2019/7/6 10:48
 * @Description:
 */

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/unAuth")
    public String unAtuh() {
        return "unAuth";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, String username, String password,
                        String captchaCode,boolean rememberMe, Model model) {

        //校验验证码
        //session中的验证码
        String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("======== "+ sessionCaptcha);
        if (null == captchaCode || !captchaCode.equalsIgnoreCase(sessionCaptcha)) {
            model.addAttribute("msg","验证码错误！");
            return "login";
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("账户不存在");
            model.addAttribute("msg", "账户不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            model.addAttribute("msg", "密码错误");
            return "login";
        }
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    /**
     * 给admin用户添加 userInfo:del 权限
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/addPermission", method = RequestMethod.GET)
    @ResponseBody
    public String addPermission(Model model) {

        //在sys_role_permission 表中  将 删除的权限 关联到admin用户所在的角色
        // roleMapper.addPermission(1,3);

        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm shiroRealm = (UserRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return "给admin用户添加 userInfo:del 权限成功";

    }

    /**
     * 删除admin用户 userInfo:del 权限
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/delPermission", method = RequestMethod.GET)
    @ResponseBody
    public String delPermission(Model model) {

        //在sys_role_permission 表中  将 删除的权限 关联到admin用户所在的角色
        //roleMapper.delPermission(1,3);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        UserRealm shiroRealm = (UserRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();

        return "删除admin用户userInfo:del 权限成功";
    }
}