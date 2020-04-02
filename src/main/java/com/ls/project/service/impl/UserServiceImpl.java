package com.ls.project.service.impl;

import com.ls.project.constants.UserConstants;
import com.ls.project.dao.RoleDao;
import com.ls.project.dao.UserDao;
import com.ls.project.entity.Role;
import com.ls.project.entity.User;
import com.ls.project.entity.User_Role;
import com.ls.project.service.UserService;
import com.ls.project.utils.FileUtil;
import com.ls.project.utils.RespPageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUserByUserName(String userName){
        return userDao.queryUserByUserName(userName);
    }

    @Override
    public User getUser() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return userDao.queryUserByUserName(user.getUserName());
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {
        if(user.getUserId()>0){
            try{
                int effectedNum =  userDao.updateUser(user);
                if(effectedNum>0){
                    User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
                    shiroUser.setUserName(user.getUserName());
                    shiroUser.setBirthday(user.getBirthday());
                    shiroUser.setPhone(user.getPhone());
                    shiroUser.setUserSignature(user.getUserSignature());
                    return true;
                }
                else{
                    throw new RuntimeException("更新信息失败");
                }
            }
            catch(Exception e){
                throw new RuntimeException("更新信息失败："+ e.toString());
            }
        }
        else {
            throw new RuntimeException("用户ID不能为负值");
        }
    }

    @Transactional
    @Override
    public boolean updateUserPassword(String oldPwd, String newPwd) {
        if(!oldPwd.equals(newPwd)) {
             try{
                //判断旧密码是否正确
                User user = (User) SecurityUtils.getSubject().getPrincipal();
                String salt = user.getSalt();
                SimpleHash sh = new SimpleHash(UserConstants.ALGORITHM_NAME, oldPwd, salt ,UserConstants.HASH_ITERATIONS);
                if(!(sh.toString()).equals(user.getUserPassword())){
                    throw new IllegalArgumentException("输入的旧密码不正确");
                }
                //更新密码
                sh = new SimpleHash(UserConstants.ALGORITHM_NAME, newPwd, salt ,UserConstants.HASH_ITERATIONS);
                int effectedNum =  userDao.updateUserPassword(sh.toString(), user.getUserId());
                if(effectedNum>0){
                    return true;
                }
                else{
                    throw new RuntimeException("密码重置失败");
                }
            }
            catch(Exception e){
                throw new RuntimeException("密码重置失败："+ e.toString());
            }
        }
        else{
            throw new RuntimeException("新密码不能与旧密码一致");
        }
    }

    @Transactional
    @Override
    public boolean updateUserAvatar(MultipartFile file) throws IOException {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String fileOriginName = file.getOriginalFilename();
        if(!fileOriginName.contains(".")){
            throw new IllegalArgumentException("缺少后缀名");
        }
        //生成文件名
        String md5 = FileUtil.fileMd5(file.getInputStream());
        fileOriginName = fileOriginName.substring(fileOriginName.lastIndexOf("."));
        String pathName = user.getUserId() + "/" + md5 + fileOriginName;
        //生成文件存储路径
        String fullPath = UserConstants.UPLOAD_FILE_PATH + pathName;
        FileUtil.saveFile(file, fullPath);
        //生成文件访问路径
        String imgURL = UserConstants.FILE_ACCESS_PATH + pathName;
        int effectedNum =  userDao.updateUserAvatar(user.getUserId(),imgURL);
        if(effectedNum > 0){
            return true;
        }
        else{
            throw new RuntimeException("头像上传失败");
        }
    }

    @Override
    public RespPageBean getAllUsers(String keyWord) {
        List<User> users = userDao.getAllUsers(keyWord);
        Long total = userDao.getTotal(keyWord);
        RespPageBean bean = new RespPageBean();
        bean.setData(users);
        bean.setTotal(total);
        return bean;
    }

    @Transactional
    @Override
    public boolean updateUserDetail(User user) {
        for(Role role:user.getRole()){
            System.out.println(role.getId());
        }
        List<User_Role> queryInDB = roleDao.getAllRoleIdByUserId(user.getUserId());
        List<Integer> common = new LinkedList<>();
        boolean flag;
        for(Role roleOut:user.getRole()){
            flag=true;
            for(User_Role roleInner:queryInDB){
                if(roleOut.getId().equals(roleInner.getRid())){
                    common.add(roleOut.getId());
                    flag=false;
                    break;
                }
            }
            if(flag){
                User_Role user_role = new User_Role(user.getUserId(),roleOut.getId());
                int effectedNum = roleDao.insertRoleIdAndUserId(user_role);
                if(effectedNum>0) {
                    System.out.println("插入成功");
                }
                else return false;
            }
        }
        for(User_Role roleInner:queryInDB){
            flag=true;
            for(Integer com:common){
                if(com.equals(roleInner.getRid())){
                    flag=false;
                    break;
                }
            }
            if(flag){
                int effectedNum = roleDao.deleteRoleIdAndUserId(user.getUserId(),roleInner.getRid());
                if(effectedNum>0) {
                    System.out.println("删除成功");
                }
                else return false;
            }
        }
        int effectedNum = userDao.updateUserDetail(user);
        if(effectedNum>0) {
            System.out.println("更新成功");
            return true;
        }
        else return false;
    }

    @Override
    public boolean deleteUser(Integer userId) {
        int effectedNum1 = userDao.deleteUser(userId);
        int effectedNum2 = roleDao.deleteAllRoleIdByUserId(userId);
        return effectedNum1>0&&effectedNum2>0;
    }
}
