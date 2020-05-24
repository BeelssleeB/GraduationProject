package com.ls.project.web;

import com.ls.project.annotation.LogAnnotation;
import com.ls.project.entity.*;
import com.ls.project.service.WorksheetInfoService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worksheet/info")
public class WorksheetInfoController {

    @Autowired
    private WorksheetInfoService worksheetInfoService;

    @GetMapping("/getalltypes")
    public List<WorksheetType> getAllTypes(){
        return worksheetInfoService.getAllTypes();
    }

    @GetMapping("/getalltools")
    public List<ToolInfo> getAllTools(){
        return worksheetInfoService.getAllTools();
    }

    @GetMapping("/getallvehicles")
    public List<VehicleInfo> getAllVehicles(){
        return worksheetInfoService.getAllVehicles();
    }

    @GetMapping("/")
    public RespPageBean getAllWorksheetInfo(@RequestParam(value="keyword") String keyWord,
                                            @RequestParam(value="page") Integer page,
                                            @RequestParam(value="size") Integer size){
        return worksheetInfoService.getAllWorksheetInfo(keyWord, page, size);
    }

    @LogAnnotation(module = "更新工单")
    @PutMapping("/updateworksheet")
    public RespBean updateWorksheetInfo(@RequestBody WorksheetInfo worksheetInfo){
        if (worksheetInfoService.updateWorksheetInfo(worksheetInfo)) {
            return RespBean.ok("工单更新成功!");
        }
        return RespBean.error("工单更新失败!");
    }

    @LogAnnotation(module = "添加工单所用工具")
    @PutMapping("/updatetool")
    public RespBean updateToolInfo(@RequestBody WorksheetInfo worksheetInfo){
        if (worksheetInfoService.updateToolInfo(worksheetInfo)) {
            return RespBean.ok("工具添加成功!");
        }
        return RespBean.error("工具添加失败!");
    }

    @LogAnnotation(module = "添加工单所用车辆")
    @PutMapping("/updatevehicle")
    public RespBean updateVehicleInfo(@RequestBody WorksheetInfo worksheetInfo){
        if (worksheetInfoService.updateVehicleInfo(worksheetInfo)) {
            return RespBean.ok("车辆添加成功!");
        }
        return RespBean.error("车辆添加失败!");
    }

    @LogAnnotation(module = "结束工单")
    @DeleteMapping("/finishworksheet/{id}")
    public RespBean deleteWarehouseById(@PathVariable Integer id){
        if(worksheetInfoService.finishWorksheetById(id)){
            return RespBean.ok("结束工单成功!");
        }
        return RespBean.error("结束工单失败!");
    }

    @LogAnnotation(module = "添加工单")
    @PostMapping("/saveworksheet")
    public RespBean saveWorksheetInfo(@RequestBody WorksheetInfo worksheetInfo){
        if (worksheetInfoService.saveWorksheetInfo(worksheetInfo)) {
            return RespBean.ok("工单添加成功!");
        }
        return RespBean.error("工单添加失败!");
    }
}
