package com.ls.project.service.impl;

import com.ls.project.dao.RoleDao;
import com.ls.project.entity.Menu;
import com.ls.project.entity.Role;
import com.ls.project.service.RoleService;
import com.ls.project.utils.RespPageBean;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public RespPageBean getAllRolesByPage(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<Role> roles= roleDao.getAllRolesByPage(keyWord,page,size);
        Long total = roleDao.getRolesTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(roles);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean deleteRole(Integer roleId) {
        int effectedNum = roleDao.deleteRole(roleId);
        roleDao.deleteRoleIdAtUser_Role(roleId);
        roleDao.deleteRoleIdAtRole_Menu(roleId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateRoleInfo(Role role) {
        Role r = roleDao.getRoleByName(role.getNameCh());
        if (r != null && r.getId() != role.getId()) {
            throw new IllegalArgumentException(role.getNameCh() + "已存在");
        }
        role.setModifyTime(new Date());
        int effectedNum = roleDao.update(role);
        saveRolePermission(role);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveRole(Role role) {
        Role r = roleDao.getRoleByName(role.getNameCh());
        if (r != null) {
            throw new IllegalArgumentException(role.getNameCh() + "已存在");
        }
        role.setModifyTime(new Date());
        role.setCreateTime(new Date());
        int effectedNum = roleDao.save(role);
        saveRolePermission(role);
        return effectedNum>0;
    }

    private void saveRolePermission(Role role) {
        List<Integer> menuId = new ArrayList<>();
        for(Menu menu:role.getMenu()){
            menuId.add(menu.getId());
        }
        roleDao.deleteRoleIdAtRole_Menu(role.getId());
        if (!CollectionUtils.isEmpty(menuId)) {
            roleDao.saveRoleIdAndMenuId(role.getId(), menuId);
        }
    }
}
