package com.ls.project.dao;

import com.ls.project.entity.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> findAllMenuByUserId(Integer userId);
}
