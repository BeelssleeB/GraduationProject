package com.ls.project.dao;

import com.ls.project.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogDao {

    int save(Log log);

    List<Log> getAllLogInfoByPage(@Param("page") Integer page, @Param("size") Integer size);

    Long getLogTotal();
}
