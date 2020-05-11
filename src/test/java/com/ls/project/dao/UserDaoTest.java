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
        List<WorksheetInfo> tools= worksheetInfoDao.getAllWorksheetByPage(null);
        for(WorksheetInfo s:tools){
            System.out.println("第"+s.getId()+"个工单信息-----------");
            System.out.println(s.getCreator());
            System.out.println(s.getBeginTime());
            System.out.println(s.getUser().getUserName());
            System.out.println(s.getWorksheetTypeName().getWorksheetType());
            System.out.println("工具信息--------");
            for(ToolInfo t:s.getToolInfoList()){
                System.out.println(t.getToolName());
            }
            System.out.println("车辆信息--------");
            for(VehicleInfo v:s.getVehicleInfoList()){
                System.out.println(v.getVehicleName());
            }
        }
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
