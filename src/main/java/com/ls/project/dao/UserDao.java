package com.ls.project.dao;

import com.ls.project.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserDao {
    User queryUserByUserName(String userName);

    int updateUser(User user);

    int updateUserPassword(@Param("userPassword")String userPassword, @Param("userId")Integer userId);

    int updateUserAvatar(@Param("userId") Integer userId, @Param("userAvatar")String userAvatar);

    Long getTotal(@Param("keyWord") String keyWord);

    List<User> getAllUsers(@Param("keyWord")String keyWord);

    int updateUserDetail(User user);

    int deleteUser(Integer userId);
}
