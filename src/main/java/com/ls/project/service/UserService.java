package com.ls.project.service;

import com.ls.project.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    User getUserByUserName(String userName);

    User getUser();

    boolean updateUser(User user);

    boolean updateUserPassword(String oldPwd, String newPwd);

    boolean updateUserAvatar(MultipartFile file) throws IOException;
}
