package com.ls.project.dao;

import com.ls.project.entity.*;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private WorksheetInfoDao worksheetInfoDao;

    @Test
    public void te(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        int e= worksheetInfoDao.insertToolStream(9,a);
        System.out.println(e);
    }

    @Test
    public void test() throws Exception {
        System.out.println(md5("123"));
    }

    public static final String md5(String password){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：为了即使相同的密码不同的盐加密后的结果也不同
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        System.out.println(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 3;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, salt, hashIterations);
        return result.toString();
    }

}
