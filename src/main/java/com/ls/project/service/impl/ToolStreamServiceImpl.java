package com.ls.project.service.impl;

import com.ls.project.dao.ToolStreamDao;
import com.ls.project.entity.ToolStream;
import com.ls.project.service.ToolStreamService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolStreamServiceImpl implements ToolStreamService {

    @Autowired
    private ToolStreamDao toolStreamDao;

    @Override
    public RespPageBean getAllToolStream(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<ToolStream> tools= toolStreamDao.getAllToolStreamByPage(keyWord,page,size);
        Long total = toolStreamDao.getToolStreamTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(tools);
        respPageBean.setTotal(total);
        return respPageBean;
    }
}
