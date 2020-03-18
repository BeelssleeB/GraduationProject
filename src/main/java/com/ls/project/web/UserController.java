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

    @PostMapping(value = "/getuserbyname")
    private Map<String,Object> getuserbyname(@RequestBody Map params){
        System.out.println(params.get("userName"));
        Map<String,Object> userMap = new HashMap<String,Object>();
        User user=userService.getUserByUserName(params.get("userName").toString());
        userMap.put("user",user);
        return userMap;
    }
}
