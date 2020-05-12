package com.ls.project.service.impl;

import com.ls.project.dao.WorksheetInfoDao;
import com.ls.project.entity.*;
import com.ls.project.service.WorksheetInfoService;
import com.ls.project.utils.RespPageBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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
    public List<ToolInfo> getAllTools() {
        return worksheetInfoDao.getAllTool();
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        return worksheetInfoDao.getAllVehicle();
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
    public boolean updateToolInfo(WorksheetInfo worksheetInfo) {
        Integer worksheetId = worksheetInfo.getId();
        List<Integer> toolIds = new ArrayList<>();
        for(ToolInfo tool:worksheetInfo.getToolInfoList()){
            toolIds.add(tool.getId());
        }
        int effectedNum = worksheetInfoDao.insertToolStream(worksheetId,toolIds);
        worksheetInfoDao.updateToolInfo(toolIds);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateVehicleInfo(WorksheetInfo worksheetInfo) {
        Integer worksheetId = worksheetInfo.getId();
        List<Integer> vehicleIds = new ArrayList<>();
        for(VehicleInfo vehicle:worksheetInfo.getVehicleInfoList()){
            vehicleIds.add(vehicle.getId());
        }
        int effectedNum = worksheetInfoDao.insertVehicleStream(worksheetId,vehicleIds);
        worksheetInfoDao.updateVehicleInfo(vehicleIds);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean finishWorksheetById(Integer worksheetId) {
        int effectedNum = worksheetInfoDao.finishWorksheet(worksheetId);
        worksheetInfoDao.finishVehicleInfo(worksheetId);
        worksheetInfoDao.finishToolInfo(worksheetId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveWorksheetInfo(WorksheetInfo worksheetInfo) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        worksheetInfo.setCreator(user.getUserId());
        worksheetInfo.setWorksheetStatus("1");
        worksheetInfo.setBeginTime(new Date());
        worksheetInfo.setEndTime(null);
        int effectedNum = worksheetInfoDao.saveWorksheetInfo(worksheetInfo);
        //得到自增主键值
        Integer worksheetId = worksheetInfo.getId();
        List<Integer> vehicleIds = new ArrayList<>();
        for(VehicleInfo vehicle:worksheetInfo.getVehicleInfoList()){
            vehicleIds.add(vehicle.getId());
        }
        List<Integer> toolIds = new ArrayList<>();
        for(ToolInfo tool:worksheetInfo.getToolInfoList()){
            toolIds.add(tool.getId());
        }
        worksheetInfoDao.insertToolStream(worksheetId,toolIds);
        worksheetInfoDao.updateToolInfo(toolIds);
        worksheetInfoDao.insertVehicleStream(worksheetId,vehicleIds);
        worksheetInfoDao.updateVehicleInfo(vehicleIds);
        return effectedNum>0;
    }
}
