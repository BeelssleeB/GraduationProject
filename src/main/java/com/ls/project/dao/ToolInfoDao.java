package com.ls.project.dao;

import com.ls.project.entity.ToolInfo;
import com.ls.project.entity.ToolType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolInfoDao {
    List<ToolType> getAllToolTypes();

    List<ToolInfo> getAllToolByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size);

    int deleteToolById(Integer toolId);

    int updateToolInfo(ToolInfo toolInfo);

    int saveToolInfo(ToolInfo toolInfo);

    Long getToolTotal(@Param("keyWord") String keyWord);
}
