package com.ls.project.service.impl;

import com.ls.project.dao.VehicleStreamDao;
import com.ls.project.entity.VehicleStream;
import com.ls.project.service.VehicleStreamService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleStreamServiceImpl implements VehicleStreamService {

    @Autowired
    private VehicleStreamDao vehicleStreamDao;

    @Override
    public RespPageBean getAllVehicleStream(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<VehicleStream> vehicles= vehicleStreamDao.getAllVehicleStreamByPage(keyWord,page,size);
        Long total = vehicleStreamDao.getVehicleStreamTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(vehicles);
        respPageBean.setTotal(total);
        return respPageBean;
    }
}
