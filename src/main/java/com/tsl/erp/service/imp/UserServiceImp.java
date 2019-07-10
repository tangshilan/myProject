package com.tsl.erp.service.imp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tsl.erp.dao.UserDao;
import com.tsl.erp.model.User;
import com.tsl.erp.model.UserData;
import com.tsl.erp.service.UserService;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:43
 * @Description:
 */

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public UserData findByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }

    @Override
    public EUDataGridResult findAllByUser(int page, int rows) {
        PageHelper.startPage(page, rows); // 分页处理
        List<UserData> users = userDao.selectAllUser();

        EUDataGridResult result = new EUDataGridResult(); // 创建一个返回值对象
        result.setRows(users);
        PageInfo<UserData> pageInfo = new PageInfo<>(users); // 取记录总条数
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    @Override
    public User findUserByNameAndId(String userName, Integer uId) {
        return userDao.selectUserByNameAndId(userName,uId);
    }

    @Override
    public User findUserById(Integer uId) {
        return userDao.selectUserById(uId);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public CustomResult addUser(UserData userData) {
        int addUserResult = userDao.insertUser(userData);

        System.out.println("=========="+ userData.getuId()+"   ====   "+userData.getrId());
        int addUserRoleResult = userDao.insertRoleUser(userData.getuId(),userData.getrId());

        if(addUserResult > 0 && addUserRoleResult > 0){
            return CustomResult.build(200, "新增用户信息成功");
        }else{
            return CustomResult.build(101, "新增用户信息失败");
        }
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public CustomResult modifyAllById(UserData userData) {

        int modifyUserResult = userDao.updateAllById(userData);
        int modifyUserRole = userDao.updateRoleByUserRole(userData.getuId(),userData.getrId());

        if(modifyUserResult > 0 && modifyUserRole > 0){
            return CustomResult.build(200, "修改用户信息成功");
        }else{
            return CustomResult.build(101, "修改用户信息失败");
        }
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public CustomResult modifyByIdSelect(UserData userData) {
        int modifyUserRole = 10;
        int modifyUserResult = userDao.updateAllById(userData);
        if (userData.getrId() != null){
            modifyUserRole = userDao.updateRoleByUserRole(userData.getuId(),userData.getrId());
        }
        if(modifyUserResult > 0 && modifyUserRole > 0){
            return CustomResult.build(200, "修改用户信息成功");
        }else{
            return CustomResult.build(101, "修改用户信息失败");
        }
    }

    @Override
    public CustomResult deleteBatch(String[] ids){
        //删除用户角色表中的记录
        int deleteUserResult = userDao.deleteBatchByUser(ids);

        int deleteUserRoleResult = userDao.deleteBatchByUserRole(ids);
        if(deleteUserResult > 0 && deleteUserRoleResult > 0){
            return CustomResult.ok();
        }else{
            return null;
        }
    }
}
