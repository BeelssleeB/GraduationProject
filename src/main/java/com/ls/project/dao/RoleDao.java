package com.ls.project.dao;

import com.ls.project.entity.Role;
import com.ls.project.entity.User_Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    List<User_Role> getAllRoleIdByUserId(@Param("uid") Integer userId);

    int deleteRoleIdAndUserId(@Param("uid") Integer userId,@Param("rid") Integer roleId);

    int insertRoleIdAndUserId(User_Role user_role);

    int deleteAllRoleIdByUserId(Integer uid);
}
