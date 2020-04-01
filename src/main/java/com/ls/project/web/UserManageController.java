package com.ls.project.web;

import com.ls.project.service.UserService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/user")
public class UserManageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public RespPageBean getAllUsers(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                    @RequestParam(value="size")Integer size,
                                    @RequestParam(value = "keyword")String keyword){
        return userService.getAllUsers(page,size,keyword);
    }
}
