package com.ls.project.service.impl;

import com.ls.project.dao.NodeInfoDao;
import com.ls.project.entity.Node;
import com.ls.project.service.NodeInfoService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NodeInfoServiceImpl implements NodeInfoService {

    @Autowired
    private NodeInfoDao nodeInfoDao;

    @Override
    public RespPageBean getAllNodeInfo(String keyWord, Integer page, Integer size) {
        if(page!=null && size!=null){
            page= (page-1)*size;
        }
        List<Node> nodes= nodeInfoDao.getAllNodeInfoByPage(keyWord,page,size);
        Long total = nodeInfoDao.getNodeTotal(keyWord);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(nodes);
        respPageBean.setTotal(total);
        return respPageBean;
    }

    @Transactional
    @Override
    public boolean deleteNodeById(Integer nodeId) {
        int effectedNum = nodeInfoDao.deleteNodeById(nodeId);
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean updateNodeInfo(Node node) {
        Node n = nodeInfoDao.getNodeByName(node.getName());
        if (n != null && n.getId() != node.getId()) {
            throw new IllegalArgumentException(node.getName() + "已存在");
        }
        int effectedNum = nodeInfoDao.updateNodeInfo(node);
        //对其他表可能的额外代码
        return effectedNum>0;
    }

    @Transactional
    @Override
    public boolean saveNodeInfo(Node node) {
        Node n = nodeInfoDao.getNodeByName(node.getName());
        if (n != null) {
            throw new IllegalArgumentException(node.getName() + "已存在");
        }
        int effectedNum = nodeInfoDao.saveNodeInfo(node);
        //对其他表可能的额外代码
        return effectedNum>0;
    }
}
