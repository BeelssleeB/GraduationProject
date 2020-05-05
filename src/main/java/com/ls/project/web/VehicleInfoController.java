package com.ls.project.web;

import com.ls.project.entity.VehicleInfo;
import com.ls.project.entity.WarehouseInfo;
import com.ls.project.service.VehicleInfoService;
import com.ls.project.utils.RespBean;
import com.ls.project.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle/info")
public class VehicleInfoController {

    @Autowired
    private VehicleInfoService vehicleInfoService;

    @GetMapping("/getalllocations")
    public List<WarehouseInfo> getAllLocations(){
        return vehicleInfoService.getAllLocations();
    }

    @GetMapping("/")
    public RespPageBean getAllVehicleInfo(@RequestParam(value="keyword") String keyWord,
                                            @RequestParam(value="page") Integer page,
                                            @RequestParam(value="size") Integer size){
        return vehicleInfoService.getAllVehicleInfo(keyWord, page, size);
    }

    @DeleteMapping("/deletevehicle/{id}")
    public RespBean deleteVehicleById(@PathVariable Integer id){
        if(vehicleInfoService.deleteVehicleById(id)){
            return RespBean.ok("车辆删除成功!");
        }
        return RespBean.error("车辆删除失败!");
    }

    @PutMapping("/updatevehicle")
    public RespBean updateVehicleInfo(@RequestBody VehicleInfo vehicleInfo){
        if (vehicleInfoService.updateVehicleInfo(vehicleInfo)) {
            return RespBean.ok("车辆更新成功!");
        }
        return RespBean.error("车辆更新失败!");
    }

    @PostMapping("/savevehicle")
    public RespBean saveWarehouseInfo(@RequestBody VehicleInfo vehicleInfo){
        if (vehicleInfoService.saveVehicleInfo(vehicleInfo)) {
            return RespBean.ok("车辆添加成功!");
        }
        return RespBean.error("车辆添加失败!");
    }
}
