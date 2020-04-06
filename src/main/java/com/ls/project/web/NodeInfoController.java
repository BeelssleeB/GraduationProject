package com.ls.project.web;

import com.ls.project.entity.Node;
import com.ls.project.entity.User;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import com.ls.project.service.NodeInfoService;
import com.ls.project.service.UserService;
import com.ls.project.service.WarehouseInfoService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/node/info")
public class NodeInfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private NodeInfoService nodeInfoService;

    @GetMapping("/getallprincipals")
    public RespPageBean getAllPrincipals(){
        return userService.getAllUsers(null);
    }

    @GetMapping("/")
    public RespPageBean getAllNodeByPage(@RequestParam(value="keyword") String keyWord,
                                         @RequestParam(value="page") Integer page,
                                         @RequestParam(value="size") Integer size){
        return nodeInfoService.getAllNodeInfo(keyWord, page, size);
    }

    @DeleteMapping("/deleteNode/{id}")
    public RespBean deleteNodeById(@PathVariable Integer id){
        if(nodeInfoService.deleteNodeById(id)){
            return RespBean.ok("节点删除成功!");
        }
        return RespBean.error("节点删除失败!");
    }

    @PutMapping("/updateNode")
    public RespBean updateNodeInfo(@RequestBody Node node){
        if (nodeInfoService.updateNodeInfo(node)) {
            return RespBean.ok("节点更新成功!");
        }
        return RespBean.error("节点更新失败!");
    }

    @PostMapping("/saveNode")
    public RespBean saveNodeInfo(@RequestBody Node node){
        if (nodeInfoService.saveNodeInfo(node)) {
            return RespBean.ok("节点保存成功!");
        }
        return RespBean.error("节点保存失败!");
    }
}

