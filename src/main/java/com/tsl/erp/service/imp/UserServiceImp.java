package com.tsl.erp.service.imp;

import com.tsl.erp.dao.UserDao;
import com.tsl.erp.model.User;
import com.tsl.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User findByUserName(String userName) {
        return userDao.selectByUserName(userName);
    }
}
