package com.ls.project.dao;

import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WarehouseInfoDao {
    List<WarehouseType> getAllWarehouseType();

    List<WarehouseInfo> getAllWarehouseByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size,@Param("typeId") Integer typeId);

    int deleteWarehouseById(Integer warehouseId);

    int updateWarehouseInfo(WarehouseInfo warehouseInfo);

    int saveWarehouseInfo(WarehouseInfo warehouseInfo);

    Long getWarehouseTotal(@Param("keyWord") String keyWord, @Param("typeId") Integer typeId);

    WarehouseInfo getWarehouseByName(String warehouseName);
}
