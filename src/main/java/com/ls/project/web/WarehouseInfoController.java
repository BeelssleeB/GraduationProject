package com.ls.project.web;

import com.ls.project.entity.Role;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.entity.WarehouseType;
import com.ls.project.service.WarehouseInfoService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouse/info")
public class WarehouseInfoController {

    @Autowired
    private WarehouseInfoService warehouseInfoService;

    @GetMapping("/getalltypes")
    public List<WarehouseType> getAllTypes(){
        return warehouseInfoService.getAllTypes();
    }

    @GetMapping("/")
    public RespPageBean getAllWarehouseInfo(@RequestParam(value="keyword") String keyWord,
                                            @RequestParam(value="page") Integer page,
                                            @RequestParam(value="size") Integer size,
                                            @RequestParam(value="typeId") Integer typeId){
        return warehouseInfoService.getAllWarehouseInfo(keyWord, page, size, typeId);
    }

    @DeleteMapping("/deleteware/{id}")
    public RespBean deleteWarehouseById(@PathVariable Integer id){
        if(warehouseInfoService.deleteWarehouseById(id)){
            return RespBean.ok("库房删除成功!");
        }
        return RespBean.error("库房删除失败!");
    }

    @PutMapping("/updateware")
    public RespBean updateWarehouseInfo(@RequestBody WarehouseInfo warehouseInfo){
        if (warehouseInfoService.updateWarehouseInfo(warehouseInfo)) {
            return RespBean.ok("库房更新成功!");
        }
        return RespBean.error("库房更新失败!");
    }

    @PostMapping("/saveware")
    public RespBean saveWarehouseInfo(@RequestBody WarehouseInfo warehouseInfo){
        if (warehouseInfoService.saveWarehouseInfo(warehouseInfo)) {
            return RespBean.ok("库房添加成功!");
        }
        return RespBean.error("库房添加失败!");
    }
}
