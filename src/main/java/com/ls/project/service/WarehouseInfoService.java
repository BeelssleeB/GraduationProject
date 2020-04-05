package com.ls.project.service;

import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface WarehouseInfoService {
    List<WarehouseType> getAllTypes();

    RespPageBean getAllWarehouseInfo(String keyWord,Integer page,Integer size,Integer typeId);

    boolean deleteWarehouseById(Integer warehouseId);

    boolean updateWarehouseInfo(WarehouseInfo warehouseInfo);

    boolean saveWarehouseInfo(WarehouseInfo warehouseInfo);
}
