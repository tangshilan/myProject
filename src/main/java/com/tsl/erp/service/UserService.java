package com.tsl.erp.service;

import com.tsl.erp.model.User;
import com.tsl.erp.model.UserData;
import com.tsl.erp.util.CustomResult;
import com.tsl.erp.util.EUDataGridResult;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:42
 * @Description:
 */

public interface UserService {
    UserData findByUserName(String UserName);
    EUDataGridResult findAllByUser(int page, int rows);
    User findUserByNameAndId(String userName, Integer rId);
    User findUserById(Integer rId);

    CustomResult addUser(UserData userData);

    CustomResult modifyAllById(UserData userData);

    CustomResult modifyByIdSelect(UserData userData);

    CustomResult deleteBatch(String[] ids);

}
