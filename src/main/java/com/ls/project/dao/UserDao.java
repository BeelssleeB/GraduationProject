package com.ls.project.dao;

import com.ls.project.entity.User;

public interface UserDao {
    User queryUserByUserName(String userName);
}
