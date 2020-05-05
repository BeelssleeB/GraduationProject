package com.ls.project.service.impl;

import com.ls.project.dao.VehicleInfoDao;
import com.ls.project.entity.VehicleInfo;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.service.VehicleInfoService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class VehicleInfoServiceImpl implements VehicleInfoService {

    @Autowired
    private VehicleInfoDao vehicleInfoDao;

    @Override
    public List<WarehouseInfo> getAllLocations() {
        return vehicleInfoDao.getAllLocations();
    }

    @Override
    public RespPageBean getAllVehicleInfo(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<VehicleInfo> vehicles= vehicleInfoDao.getAllVehicleInfoByPage(keyWord,page,size);
        Long total = vehicleInfoDao.getVehicleTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(vehicles);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean deleteVehicleById(Integer vehicleId) {
        int effectedNum = vehicleInfoDao.deleteVehicleById(vehicleId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateVehicleInfo(VehicleInfo vehicleInfo) {
        vehicleInfo.setModifyTime(new Date());
        int effectedNum = vehicleInfoDao.updateVehicleInfo(vehicleInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveVehicleInfo(VehicleInfo vehicleInfo) {
        vehicleInfo.setModifyTime(new Date());
        vehicleInfo.setCreateTime(new Date());
        int effectedNum = vehicleInfoDao.saveVehicleInfo(vehicleInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }
}
