package com.ls.project.service;

import com.ls.project.entity.Menu;

import java.util.List;
import java.util.Set;

public interface MenuService {
    List<Menu> findAllMenuByUserId();

    Set<String> findAllPermissionByUserId();
}
