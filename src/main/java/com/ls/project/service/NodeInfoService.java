package com.ls.project.service;

import com.ls.project.entity.Node;
import com.ls.project.utils.RespPageBean;

public interface NodeInfoService {
    RespPageBean getAllNodeInfo(String keyWord, Integer page, Integer size);

    boolean deleteNodeById(Integer nodeId);

    boolean updateNodeInfo(Node node);

    boolean saveNodeInfo(Node node);
}
