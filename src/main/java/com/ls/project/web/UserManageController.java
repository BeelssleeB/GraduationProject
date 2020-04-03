package com.ls.project.web;

import com.ls.project.entity.Role;
import com.ls.project.entity.User;
import com.ls.project.service.RoleService;
import com.ls.project.service.UserService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class UserManageController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public RespPageBean getAllUsers(@RequestParam(value = "keyword")String keyword){
        return userService.getAllUsers(keyword);
    }

    @GetMapping("/getallroles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/updateuser")
    public RespBean putUserInfo(@RequestBody User user) {
        if(userService.updateUserDetail(user)){
            return RespBean.ok("信息更新成功!");
        }
        return RespBean.error("信息更新失败!");
    }

    @DeleteMapping("/deleteuser/{id}")
    public RespBean deleteUser(@PathVariable Integer id){
        if (userService.deleteUser(id)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
