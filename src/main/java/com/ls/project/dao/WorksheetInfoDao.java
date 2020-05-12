package com.ls.project.dao;

import com.ls.project.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorksheetInfoDao {
    List<WorksheetType> getAllWorksheetType();

    List<ToolInfo> getAllTool();

    List<VehicleInfo> getAllVehicle();

    List<WorksheetInfo> getAllWorksheetByPage(@Param("keyWord") String keyWord);

    int updateWorksheetInfo(WorksheetInfo worksheetInfo);

    int insertToolStream(@Param("worksheetId") Integer worksheetId,@Param("toolIds") List<Integer> toolIds);

    int updateToolInfo(@Param("toolIds") List<Integer> toolIds);

    int insertVehicleStream(@Param("worksheetId") Integer worksheetId,@Param("vehicleIds") List<Integer> vehicleIds);

    int updateVehicleInfo(@Param("vehicleIds") List<Integer> vehicleIds);

    Long getWorksheetTotal(@Param("keyWord") String keyWord);

    int finishWorksheet(Integer worksheetId);

    int finishVehicleInfo(Integer worksheetId);

    int finishToolInfo(Integer worksheetId);

    int saveWorksheetInfo(WorksheetInfo worksheetInfo);
}
