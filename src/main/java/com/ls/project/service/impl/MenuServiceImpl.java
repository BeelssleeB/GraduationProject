package com.ls.project.service.impl;

import com.ls.project.dao.MenuDao;
import com.ls.project.dao.UserDao;
import com.ls.project.entity.Menu;
import com.ls.project.entity.User;
import com.ls.project.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAllMenuByUserId() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Menu> menus = menuDao.findAllMenuByUserId(user.getUserId());
        return getMenus(menus);
    }

    @Override
    public List<Menu> getAllMenus() {
        List<Menu> menus = menuDao.getAllMenus();
        return getMenus(menus);
    }

    @Override
    public List<Integer> getMenuByRoleId(Integer roleId) {
        return menuDao.getMenuByRoleId(roleId);
    }

    @Override
    public Set<String> findAllPermissionByUserId() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<String> permissions = menuDao.findAllPermissionByUserId(user.getUserId());
        Set<String> permission = new HashSet<>();
        for(String str: permissions) {
            if(!str.equals("::")){
                permission.add(str);
            }
        }
        return permission;
    }

    private List<Menu> getMenus(List<Menu> menus) {
        final List<Menu> finalMenus = menus;
        List<Menu> firstLevel = finalMenus.stream().filter(p -> p.getParentId().equals(0)).collect(Collectors.toList());
        firstLevel.parallelStream().forEach(p -> {
            setChild(p, finalMenus);
        });
        return firstLevel;
    }

    private void setChild(Menu p, List<Menu> permissions) {
        List<Menu> child = permissions.parallelStream().filter(a -> a.getParentId().equals(p.getId())).collect(Collectors.toList());
        p.setChildren(child);
        if (!CollectionUtils.isEmpty(child)) {
            child.parallelStream().forEach(c -> {
                //递归设置子元素，多级菜单支持
                setChild(c, permissions);
            });
        }
    }
}
