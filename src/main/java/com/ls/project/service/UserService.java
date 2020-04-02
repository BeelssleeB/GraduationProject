package com.ls.project.service;

import com.ls.project.entity.User;
import com.ls.project.utils.RespPageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User getUserByUserName(String userName);

    User getUser();

    boolean updateUser(User user);

    boolean updateUserPassword(String oldPwd, String newPwd);

    boolean updateUserAvatar(MultipartFile file) throws IOException;

    RespPageBean getAllUsers(String keyWord);

    boolean updateUserDetail(User user);

    boolean deleteUser(Integer userId);
}
