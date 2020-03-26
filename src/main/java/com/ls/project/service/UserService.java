package com.ls.project.service;

import com.ls.project.entity.User;

public interface UserService {
    User getUserByUserName(String userName);

    User getUser();

    boolean updateUser(User user);

    boolean updateUserPassword(String oldPwd, String newPwd);
}
