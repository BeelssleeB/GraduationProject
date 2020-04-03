package com.ls.project.service;

import com.ls.project.entity.Role;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    RespPageBean getAllRolesByPage(String keyWord, Integer page, Integer size);

    boolean deleteRole(Integer roleId);

    boolean updateRoleInfo(Role role);

    boolean saveRole(Role role);
}
