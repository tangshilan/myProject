package com.tsl.erp.service;

import com.tsl.erp.model.User;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface UserService {
    User findByUserName(String UserName);
}
