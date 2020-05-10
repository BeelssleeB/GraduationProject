package com.ls.project.dao;

import com.ls.project.entity.ToolStream;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ToolStreamDao {
    List<ToolStream> getAllToolStreamByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size);

    Long getToolStreamTotal(@Param("keyWord") String keyWord);
}
