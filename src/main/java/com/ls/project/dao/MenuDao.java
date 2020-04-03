package com.ls.project.dao;

import com.ls.project.entity.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> findAllMenuByUserId(Integer userId);

    List<String> findAllPermissionByUserId(Integer userId);

    List<Menu> getAllMenus();

    List<Integer> getMenuByRoleId(Integer roleId);
}
