package com.ls.project.service;

import com.ls.project.entity.VehicleInfo;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface VehicleInfoService {

    List<WarehouseInfo> getAllLocations();

    RespPageBean getAllVehicleInfo(String keyWord, Integer page, Integer size);

    boolean deleteVehicleById(Integer vehicleId);

    boolean updateVehicleInfo(VehicleInfo vehicleInfo);

    boolean saveVehicleInfo(VehicleInfo vehicleInfo);
}
