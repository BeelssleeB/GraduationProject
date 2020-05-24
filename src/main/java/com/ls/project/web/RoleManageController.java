package com.ls.project.web;

import com.ls.project.annotation.LogAnnotation;
import com.ls.project.entity.Menu;
import com.ls.project.entity.Role;
import com.ls.project.service.MenuService;
import com.ls.project.service.RoleService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jnlp.IntegrationService;
import java.util.List;

@RestController
@RequestMapping("/sys/role")
public class RoleManageController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public RespPageBean getAllRoles(@RequestParam(value="keyword") String keyWord,
                                    @RequestParam(value="page") Integer page,
                                    @RequestParam(value="size") Integer size){
        return roleService.getAllRolesByPage(keyWord,page,size);
    }

    @GetMapping("/getallmenus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @GetMapping("/getmenubyroleid/{id}")
    public List<Integer> getMenuByRoleId(@PathVariable Integer id){
        return menuService.getMenuByRoleId(id);
    }

    @LogAnnotation(module = "更新角色")
    @PutMapping("/updaterole")
    public RespBean updateRoleInfo(@RequestBody Role role){
        if (roleService.updateRoleInfo(role)) {
            return RespBean.ok("角色更新成功!");
        }
        return RespBean.error("角色更新失败!");
    }

    @LogAnnotation(module = "添加角色")
    @PostMapping("/saverole")
    public RespBean saveRoleInfo(@RequestBody Role role){
        if (roleService.saveRole(role)) {
            return RespBean.ok("角色添加成功!");
        }
        return RespBean.error("角色添加失败!");
    }

    @LogAnnotation(module = "删除角色")
    @DeleteMapping("/deleterole/{id}")
    public RespBean deleteUser(@PathVariable Integer id){
        if (roleService.deleteRole(id)) {
            return RespBean.ok("角色删除成功!");
        }
        return RespBean.error("角色删除失败!");
    }
}
