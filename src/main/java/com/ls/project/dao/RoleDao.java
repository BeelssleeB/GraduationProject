package com.ls.project.dao;

import com.ls.project.entity.Role;
import com.ls.project.entity.User_Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    List<Role> getAllRolesByPage(@Param("keyWord") String keyWord,@Param("page") Integer page,@Param("size") Integer size);

    Long getRolesTotal(String keyWord);

    List<User_Role> getAllRoleIdByUserId(@Param("uid") Integer userId);

    Role getRoleByName(String nameCh);

    int deleteRole(Integer roleId);

    int deleteRoleIdAtUser_Role(Integer roleId);

    int deleteRoleIdAtRole_Menu(Integer roleId);

    int deleteRoleIdAndUserId(@Param("uid") Integer userId,@Param("rid") Integer roleId);

    int insertRoleIdAndUserId(User_Role user_role);

    int deleteAllRoleIdByUserId(Integer uid);

    int saveRoleIdAndMenuId(@Param("roleId") Integer roleId,@Param("menuIds") List<Integer> menuIds);

    int update(Role role);

    int save(Role role);
}
