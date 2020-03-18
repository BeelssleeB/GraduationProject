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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Menu> findAllMenuByUserId() {
        String userName = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userDao.queryUserByUserName(userName);
        List<Menu> menus = menuDao.findAllMenuByUserId(user.getUserId());
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
