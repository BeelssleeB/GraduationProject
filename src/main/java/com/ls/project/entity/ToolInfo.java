package com.ls.project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ToolInfo {
    private Integer id;
    private String toolCode;
    private String toolName;
    private Integer toolType;
    private String toolLocation;
    private String note;
    private String unit;
    private Integer useTime;
    private String toolStatus;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date modifyTime;

    private ToolType toolTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public Integer getToolType() {
        return toolType;
    }

    public void setToolType(Integer toolType) {
        this.toolType = toolType;
    }

    public String getToolLocation() {
        return toolLocation;
    }

    public void setToolLocation(String toolLocation) {
        this.toolLocation = toolLocation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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

    public ToolType getToolTypeName() {
        return toolTypeName;
    }

    public void setToolTypeName(ToolType toolTypeName) {
        this.toolTypeName = toolTypeName;
    }

    public Integer getUseTime() {
        return useTime;
    }

    public void setUseTime(Integer useTime) {
        this.useTime = useTime;
    }


    public String getToolStatus() {
        return toolStatus;
    }

    public void setToolStatus(String toolStatus) {
        this.toolStatus = toolStatus;
    }
}
