package com.ls.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class WorksheetInfo {
    private Integer id;
    private Integer creator;
    private String worksheetName;
    private String worksheetValue;
    private Integer worksheetType;
    private String note;
    private String worksheetStatus;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date endTime;

    private User user;
    private WorksheetType worksheetTypeName;
    private List<ToolInfo> toolInfoList;
    private List<VehicleInfo> vehicleInfoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getWorksheetName() {
        return worksheetName;
    }

    public void setWorksheetName(String worksheetName) {
        this.worksheetName = worksheetName;
    }

    public String getWorksheetValue() {
        return worksheetValue;
    }

    public void setWorksheetValue(String worksheetValue) {
        this.worksheetValue = worksheetValue;
    }

    public Integer getWorksheetType() {
        return worksheetType;
    }

    public void setWorksheetType(Integer worksheetType) {
        this.worksheetType = worksheetType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWorksheetStatus() {
        return worksheetStatus;
    }

    public void setWorksheetStatus(String worksheetStatus) {
        this.worksheetStatus = worksheetStatus;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorksheetType getWorksheetTypeName() {
        return worksheetTypeName;
    }

    public void setWorksheetTypeName(WorksheetType worksheetTypeName) {
        this.worksheetTypeName = worksheetTypeName;
    }

    public List<ToolInfo> getToolInfoList() {
        return toolInfoList;
    }

    public void setToolInfoList(List<ToolInfo> toolInfoList) {
        this.toolInfoList = toolInfoList;
    }

    public List<VehicleInfo> getVehicleInfoList() {
        return vehicleInfoList;
    }

    public void setVehicleInfoList(List<VehicleInfo> vehicleInfoList) {
        this.vehicleInfoList = vehicleInfoList;
    }
}
