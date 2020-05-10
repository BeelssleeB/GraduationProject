package com.ls.project.web;

import com.ls.project.service.VehicleStreamService;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle/borrowing")
public class VehicleStreamController {

    @Autowired
    private VehicleStreamService vehicleStreamService;

    @GetMapping("/")
    public RespPageBean getAllToolStream(@RequestParam(value="keyword") String keyWord,
                                         @RequestParam(value="page") Integer page,
                                         @RequestParam(value="size") Integer size){
        return vehicleStreamService.getAllVehicleStream(keyWord, page, size);
    }
}
