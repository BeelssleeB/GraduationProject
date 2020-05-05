package com.ls.project.dao;

import com.ls.project.entity.VehicleInfo;
import com.ls.project.entity.WarehouseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleInfoDao {
    List<WarehouseInfo> getAllLocations();

    List<VehicleInfo> getAllVehicleInfoByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size);

    int deleteVehicleById(Integer vehicleId);

    int updateVehicleInfo(VehicleInfo vehicleInfo);

    int saveVehicleInfo(VehicleInfo vehicleInfo);

    Long getVehicleTotal(@Param("keyWord") String keyWord);
}
