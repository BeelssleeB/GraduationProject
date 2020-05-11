package com.ls.project.dao;

import com.ls.project.entity.WorksheetInfo;
import com.ls.project.entity.WorksheetType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorksheetInfoDao {
    List<WorksheetType> getAllWorksheetType();

    List<WorksheetInfo> getAllWorksheetByPage(@Param("keyWord") String keyWord);

    int updateWorksheetInfo(WorksheetInfo worksheetInfo);

    Long getWorksheetTotal(@Param("keyWord") String keyWord);

    int finishWorksheet(Integer worksheetId);

    int finishVehicleInfo(Integer worksheetId);

    int finishWorksheetStream(Integer worksheetId);
}
