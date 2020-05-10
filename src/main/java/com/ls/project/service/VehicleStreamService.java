package com.ls.project.service;

import com.ls.project.utils.RespPageBean;

public interface VehicleStreamService {

    RespPageBean getAllVehicleStream(String keyWord, Integer page, Integer size);
}
