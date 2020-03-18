package com.ls.project.service;

import com.ls.project.entity.User;

import java.text.ParseException;

public interface UserService {
    User getUserByUserName(String userName);
}
