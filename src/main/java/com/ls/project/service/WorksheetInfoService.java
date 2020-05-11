package com.ls.project.service;

import com.ls.project.entity.WorksheetInfo;
import com.ls.project.entity.WorksheetType;
import com.ls.project.utils.RespPageBean;

import java.util.List;

public interface WorksheetInfoService {
    List<WorksheetType> getAllTypes();

    RespPageBean getAllWorksheetInfo(String keyWord, Integer page, Integer size);

    boolean updateWorksheetInfo(WorksheetInfo worksheetInfo);

    boolean finishWorksheetById(Integer worksheetId);
}
