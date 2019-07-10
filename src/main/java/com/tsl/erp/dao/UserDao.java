package com.tsl.erp.dao;

import com.tsl.erp.model.User;
import com.tsl.erp.model.UserData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/7 9:40
 * @Description:
 */

public interface UserDao {

    UserData selectByUserName(String userName);
    List<UserData> selectAllUser();

    User selectUserByNameAndId(@Param("userName")String userName, @Param("uId")Integer uId);
    User selectUserById(Integer uId);

    int insertUser(@Param("user")UserData user);

    // 传入两个以上的参数时需要加上@Param注解
    int insertRoleUser(@Param("uId")Integer uId, @Param("rId")Integer rId);

    int updateAllById(@Param("user")UserData user);

    int updateByIdSelect(@Param("user")UserData user);

    int updateRoleByUserRole(@Param("uId")Integer uId, @Param("rId")Integer rId);

    int deleteBatchByUser(String[] ids);

    int deleteBatchByUserRole(String[] ids);

}
