package com.ls.project.web;

import com.ls.project.entity.User;
import com.ls.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getuserinfo")
    private Map<String,Object> getuser(){
        Map<String,Object> userMap = new HashMap<String,Object>();
        User user=userService.getUser();
        userMap.put("user",user);
        return userMap;
    }
}
