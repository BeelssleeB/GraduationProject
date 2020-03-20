package com.ls.project.service.impl;

import com.ls.project.dao.UserDao;
import com.ls.project.entity.User;
import com.ls.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName){
        User user = userDao.queryUserByUserName(userName);
        //user.setBirthday(DateUtil.stringToDate(DateUtil.dateToString(user.getBirthday())));
        return user;
    }
}
