package com.ls.project.service;

import com.ls.project.entity.ToolInfo;
import com.ls.project.entity.ToolType;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface ToolInfoService {
    List<ToolType> getAllTypes();

    RespPageBean getAllToolInfo(String keyWord, Integer page, Integer size);

    boolean deleteToolById(Integer toolId);

    boolean updateToolInfo(ToolInfo toolInfo);

    boolean saveToolInfo(ToolInfo toolInfo);
}
