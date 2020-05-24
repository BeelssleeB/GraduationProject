package com.ls.project.web;

import com.ls.project.dao.LogDao;
import com.ls.project.entity.Log;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sys/log")
public class LogController {

    @Autowired
    private LogDao logDao;

    @GetMapping("/")
    public RespPageBean getAllToolInfo(@RequestParam(value="page") Integer page,
                                       @RequestParam(value="size") Integer size){
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<Log> infos= logDao.getAllLogInfoByPage(page,size);
        Long total = logDao.getLogTotal();
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(infos);
        respPageBean.setTotal(total);
        return respPageBean;
    }
}
