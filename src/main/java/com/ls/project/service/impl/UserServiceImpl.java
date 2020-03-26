package com.ls.project.service.impl;

import com.ls.project.constants.UserConstants;
import com.ls.project.dao.UserDao;
import com.ls.project.entity.User;
import com.ls.project.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName){
        User user = userDao.queryUserByUserName(userName);
        return user;
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
                int effectedNum =  userDao.updateUserPassword(sh.toString(), user.getUserName());
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

}
