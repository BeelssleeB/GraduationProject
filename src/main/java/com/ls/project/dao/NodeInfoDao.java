package com.ls.project.dao;

import com.ls.project.entity.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NodeInfoDao {
    List<Node> getAllNodeInfoByPage(@Param("keyWord") String keyWord, @Param("page") Integer page, @Param("size") Integer size);

    int deleteNodeById(Integer nodeId);

    int updateNodeInfo(Node node);

    int saveNodeInfo(Node node);

    Long getNodeTotal(@Param("keyWord") String keyWord);

    Node getNodeByName(String nodeName);
}
