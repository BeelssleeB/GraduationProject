package com.ls.project.web;

import com.ls.project.entity.User;
import com.ls.project.service.UserService;
import com.ls.project.utils.RespBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getuserinfo")
    public Map<String,Object> getUser(){
        Map<String,Object> userMap = new HashMap<String,Object>();
        User user=userService.getUser();
        userMap.put("user",user);
        return userMap;
    }

    @PutMapping(value="/putuserinfo")
    public RespBean putUserInfo(@RequestBody User user) {
        if(userService.updateUser(user)){
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PutMapping(value="/updatepwd")
    public RespBean putUserPwd(@RequestBody Map<String ,Object> pwd) {
        String oldPwd = (String) pwd.get("oldpwd");
        String newPwd = (String) pwd.get("newpwd");
        if (userService.updateUserPassword(oldPwd, newPwd)) {
            return RespBean.ok("密码重置成功!");
        }
        return RespBean.error("密码重置失败!");
    }

    @PostMapping(value="/useravatar")
    public RespBean updateUserAvatar(MultipartFile file) throws IOException {
        if(userService.updateUserAvatar(file)){
            return RespBean.ok("头像设置成功!");
        }
        return RespBean.error("头像设置失败!");
    }
}
