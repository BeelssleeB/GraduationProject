package com.ls.project.service;

import com.ls.project.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> findAllMenuByUserId();
}
