package com.ls.project.web;

import com.ls.project.service.ToolStreamService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tool/borrowing")
public class ToolStreamController {

    @Autowired
    private ToolStreamService toolStreamService;

    @GetMapping("/")
    public RespPageBean getAllToolStream(@RequestParam(value="keyword") String keyWord,
                                       @RequestParam(value="page") Integer page,
                                       @RequestParam(value="size") Integer size){
        return toolStreamService.getAllToolStream(keyWord, page, size);
    }
}
