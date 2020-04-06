package com.ls.project.service.impl;

import com.ls.project.dao.WarehouseInfoDao;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import com.ls.project.service.WarehouseInfoService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WarehouseInfoServiceImpl implements WarehouseInfoService {

    @Autowired
    private WarehouseInfoDao warehouseInfoDao;

    @Override
    public List<WarehouseType> getAllTypes() {
        return warehouseInfoDao.getAllWarehouseType();
    }

    @Override
    public RespPageBean getAllWarehouseInfo(String keyWord, Integer page, Integer size, Integer typeId) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<WarehouseInfo> infos= warehouseInfoDao.getAllWarehouseByPage(keyWord,page,size,typeId);
        Long total = warehouseInfoDao.getWarehouseTotal(keyWord,typeId);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(infos);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean deleteWarehouseById(Integer warehouseId) {
        int effectedNum = warehouseInfoDao.deleteWarehouseById(warehouseId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateWarehouseInfo(WarehouseInfo warehouseInfo) {
        WarehouseInfo w = warehouseInfoDao.getWarehouseByName(warehouseInfo.getWarehouseName());
        if (w != null && w.getId() != warehouseInfo.getId()) {
            throw new IllegalArgumentException(warehouseInfo.getWarehouseName() + "已存在");
        }
        int effectedNum = warehouseInfoDao.updateWarehouseInfo(warehouseInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveWarehouseInfo(WarehouseInfo warehouseInfo) {
        WarehouseInfo w = warehouseInfoDao.getWarehouseByName(warehouseInfo.getWarehouseName());
        if (w != null) {
            throw new IllegalArgumentException(warehouseInfo.getWarehouseName() + "已存在");
        }
        int effectedNum = warehouseInfoDao.saveWarehouseInfo(warehouseInfo);
        //对其他表可能的额外代码
        return effectedNum>0;
    }
}
