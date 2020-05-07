package com.ls.project.web;

import com.ls.project.entity.ToolInfo;
import com.ls.project.entity.ToolType;
import com.ls.project.service.ToolInfoService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tool/type")
public class ToolInfoController {

    @Autowired
    private ToolInfoService toolInfoService;

    @GetMapping("/getalltypes")
    public List<ToolType> getAllTypes(){
        return toolInfoService.getAllTypes();
    }

    @GetMapping("/")
    public RespPageBean getAllToolInfo(@RequestParam(value="keyword") String keyWord,
                                            @RequestParam(value="page") Integer page,
                                            @RequestParam(value="size") Integer size){
        return toolInfoService.getAllToolInfo(keyWord, page, size);
    }

    @DeleteMapping("/deletetool/{id}")
    public RespBean deleteToolById(@PathVariable Integer id){
        if(toolInfoService.deleteToolById(id)){
            return RespBean.ok("工具删除成功!");
        }
        return RespBean.error("工具删除失败!");
    }

    @PutMapping("/updatetool")
    public RespBean updateToolInfo(@RequestBody ToolInfo toolInfo){
        if (toolInfoService.updateToolInfo(toolInfo)) {
            return RespBean.ok("工具更新成功!");
        }
        return RespBean.error("工具更新失败!");
    }

    @PostMapping("/savetool")
    public RespBean saveToolInfo(@RequestBody ToolInfo toolInfo){
        if (toolInfoService.saveToolInfo(toolInfo)) {
            return RespBean.ok("工具添加成功!");
        }
        return RespBean.error("工具添加失败!");
    }
}
