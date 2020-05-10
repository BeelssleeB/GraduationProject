package com.ls.project.dao;

import com.ls.project.entity.VehicleStream;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VehicleStreamDao {
    List<VehicleStream> getAllVehicleStreamByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size);

    Long getVehicleStreamTotal(@Param("keyWord") String keyWord);
}
