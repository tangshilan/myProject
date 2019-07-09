package com.tsl.erp.controller;

import com.google.code.kaptcha.Constants;
import com.google.common.collect.Maps;
import com.tsl.erp.model.User;
import com.tsl.erp.service.UserService;
import com.tsl.erp.shiro.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/7/6 10:48
 * @Description:
 */

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/unAuth")
    public String unAtuh() {
        return "unAuth";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam String username, @RequestParam String password,
                                    @RequestParam(required=false)String captchaCode,@RequestParam(required=false)boolean rememberMe) {
        Map<String,Object> map = Maps.newHashMap();

        if(!StringUtils.isEmpty(captchaCode)){
            // 校验验证码    session中的验证码
            String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (null == captchaCode || !captchaCode.equalsIgnoreCase(sessionCaptcha)) {
                //model.addAttribute("msg","验证码错误！");
                System.out.println("验证码错误!");
                map.put("msg","captchaCode_error");
                // return "login";
            }
        }

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("账户不存在");
            //model.addAttribute("msg", "账户不存在");
            map.put("msg","account_error");
          //  return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            //model.addAttribute("msg", "密码错误");
            map.put("msg","password_error");
           // return "login";
        }
       // return "index";
        return map;
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @GetMapping({"/", "/index"})
    public String index(HttpSession session, Model model) {
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User)subject.getPrincipal();
        model.addAttribute("user",currentUser);
        return "/index";
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