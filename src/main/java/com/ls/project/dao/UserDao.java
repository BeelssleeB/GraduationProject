package com.ls.project.dao;

import com.ls.project.entity.User;
import org.apache.ibatis.annotations.Param;

public interface
UserDao {
    User queryUserByUserName(String userName);

    int updateUser(User user);

    int updateUserPassword(@Param("userPassword")String userPassword, @Param("userName")String userName);
}
