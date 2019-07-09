package com.tsl.erp.shiro;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.tsl.erp.model.Permission;
import com.tsl.erp.model.User;
import com.tsl.erp.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * @Date
     * @Description 用户授权
     * @Param null
     * @return
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型
        User user = (User)principalCollection.getPrimaryPrincipal();

        List<String> permissions = Lists.newArrayList();
        Set<String> roles = Sets.newHashSet();

        roles.add(user.getRoles().getRole());
        // 获取权限中的percode的值，如：order:add
        for (Permission permission : user.getRoles().getPermission()){
            permissions.add(permission.getPercode());
        }
        // 查到权限数据，返回授权信息(要包括 上边的permissions)
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
        simpleAuthorizationInfo.addStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);

        return simpleAuthorizationInfo;
    }

    /**
     * @Date
     * @Description  用户认证
     * @Param null
     * @return
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // token是用户输入的用户名和密码,第一步从token中取出用户名
        String userName = (String)authenticationToken.getPrincipal();

        // 第二步：根据用户输入的username从数据库查询
        User user = userService.findByUserName(userName);

        if (user == null) {
            logger.debug("该用户不存在!");
            return null;
        }
//        String passwod = user.getPassword();
//        ActiveUser activeUser = new ActiveUser();
//
//        List<Permission> permissionsList = Lists.newArrayList();
//
//        for(Permission permission : user.getRole().getPermission()){
//            permissionsList.add(permission);
//        }
//
//        activeUser.setUserId(user.getuId());
//        activeUser.setUserName(user.getUserName());
//        activeUser.setUserStatus(user.getLocked());
//        activeUser.setRoleName(user.getRole().getRole());
//        activeUser.setMenus(permissionsList);
//        activeUser.setRoleStatus(user.getRole().getAvailable());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return info;
    }

    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
