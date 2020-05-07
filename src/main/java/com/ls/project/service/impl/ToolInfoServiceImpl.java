package com.ls.project.service.impl;

import com.ls.project.dao.ToolInfoDao;
import com.ls.project.entity.ToolInfo;
import com.ls.project.entity.ToolType;
import com.ls.project.service.ToolInfoService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ToolInfoServiceImpl implements ToolInfoService {

    @Autowired
    private ToolInfoDao toolInfoDao;

    @Override
    public List<ToolType> getAllTypes() {
        return toolInfoDao.getAllToolTypes();
    }

    @Override
    public RespPageBean getAllToolInfo(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<ToolInfo> infos= toolInfoDao.getAllToolByPage(keyWord,page,size);
        Long total = toolInfoDao.getToolTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(infos);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean deleteToolById(Integer toolId) {
        int effectedNum = toolInfoDao.deleteToolById(toolId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateToolInfo(ToolInfo toolInfo) {
        toolInfo.setModifyTime(new Date());
        int effectedNum = toolInfoDao.updateToolInfo(toolInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveToolInfo(ToolInfo toolInfo) {
        toolInfo.setModifyTime(new Date());
        toolInfo.setCreateTime(new Date());
        int effectedNum = toolInfoDao.saveToolInfo(toolInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }
}
