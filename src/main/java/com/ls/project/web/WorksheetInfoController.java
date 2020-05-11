package com.ls.project.web;

import com.ls.project.entity.WorksheetInfo;
import com.ls.project.entity.WorksheetType;
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

    @GetMapping("/")
    public RespPageBean getAllWorksheetInfo(@RequestParam(value="keyword") String keyWord,
                                            @RequestParam(value="page") Integer page,
                                            @RequestParam(value="size") Integer size){
        return worksheetInfoService.getAllWorksheetInfo(keyWord, page, size);
    }

    @PutMapping("/updateworksheet")
    public RespBean updateWorksheetInfo(@RequestBody WorksheetInfo worksheetInfo){
        if (worksheetInfoService.updateWorksheetInfo(worksheetInfo)) {
            return RespBean.ok("工单更新成功!");
        }
        return RespBean.error("工单更新失败!");
    }

    @DeleteMapping("/finishworksheet/{id}")
    public RespBean deleteWarehouseById(@PathVariable Integer id){
        if(worksheetInfoService.finishWorksheetById(id)){
            return RespBean.ok("结束工单成功!");
        }
        return RespBean.error("结束工单失败!");
    }
}
