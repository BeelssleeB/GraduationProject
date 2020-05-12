package com.ls.project.service;

import com.ls.project.entity.*;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface WorksheetInfoService {
    List<WorksheetType> getAllTypes();

    List<ToolInfo> getAllTools();

    List<VehicleInfo> getAllVehicles();

    RespPageBean getAllWorksheetInfo(String keyWord, Integer page, Integer size);

    boolean updateWorksheetInfo(WorksheetInfo worksheetInfo);

    boolean updateToolInfo(WorksheetInfo worksheetInfo);

    boolean updateVehicleInfo(WorksheetInfo worksheetInfo);

    boolean finishWorksheetById(Integer worksheetId);

    boolean saveWorksheetInfo(WorksheetInfo worksheetInfo);
}
