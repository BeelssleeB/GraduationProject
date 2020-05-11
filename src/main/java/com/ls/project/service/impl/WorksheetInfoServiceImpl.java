package com.ls.project.service.impl;

import com.ls.project.dao.WorksheetInfoDao;
import com.ls.project.entity.WorksheetInfo;
import com.ls.project.entity.WorksheetType;
import com.ls.project.service.WorksheetInfoService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorksheetInfoServiceImpl implements WorksheetInfoService {

    @Autowired
    private WorksheetInfoDao worksheetInfoDao;

    @Override
    public List<WorksheetType> getAllTypes() {
        return worksheetInfoDao.getAllWorksheetType();
    }

    @Override
    public RespPageBean getAllWorksheetInfo(String keyWord, Integer page, Integer size) {
        Integer mul = 0;
        if(page!=null && size!=null){
            mul= page*size;
        }
        List<WorksheetInfo> infos= worksheetInfoDao.getAllWorksheetByPage(keyWord);
        List<WorksheetInfo> res;
        if(page>(infos.size()/size)){
            res = infos.subList(mul-size,infos.size());
        }
        else{
            res = infos.subList(mul-size,mul);
        }
        Long total = worksheetInfoDao.getWorksheetTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(res);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean updateWorksheetInfo(WorksheetInfo worksheetInfo) {
        int effectedNum = worksheetInfoDao.updateWorksheetInfo(worksheetInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean finishWorksheetById(Integer worksheetId) {
        int effectedNum = worksheetInfoDao.finishWorksheet(worksheetId);
        worksheetInfoDao.finishVehicleInfo(worksheetId);
        worksheetInfoDao.finishWorksheetStream(worksheetId);
        return effectedNum>0;
    }
}
