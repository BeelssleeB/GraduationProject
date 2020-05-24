package com.ls.project.service.impl;

import com.ls.project.dao.LogDao;
import com.ls.project.entity.Log;
import com.ls.project.entity.User;
import com.ls.project.service.LogService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Transactional
    @Override
    public void save(Log log) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user == null || user.getUserId() == null) {
            return;
        }
        log.setUser(user);
        logDao.save(log);
    }
}
