package com.ls.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VehicleInfo {
    private Integer id;
    private String vehicleName;
    private String vehicleCode;
    private Integer vehicleLocation;
    private String note;
    private String vehicleStatus;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;

    private WarehouseInfo warehouseInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(String vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public Integer getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(Integer vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public WarehouseInfo getWarehouseInfo() {
        return warehouseInfo;
    }

    public void setWarehouseInfo(WarehouseInfo warehouseInfo) {
        this.warehouseInfo = warehouseInfo;
    }


    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
