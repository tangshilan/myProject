package com.tsl.erp.dao;

import com.tsl.erp.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:40
 * @Description:
 */

@Mapper
public interface UserDao {

    User selectByUserName(String userName);
}
