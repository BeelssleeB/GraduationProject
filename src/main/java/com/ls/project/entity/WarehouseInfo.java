package com.ls.project.entity;

public class WarehouseInfo {
    private Integer id;
    private String treasureCode;
    private String warehouseName;
    private Integer warehouseType;
    private String node;
    private String note;
    private WarehouseType warehouseTypeClass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTreasureCode() {
        return treasureCode;
    }

    public void setTreasureCode(String treasureCode) {
        this.treasureCode = treasureCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getWarehouseType() {
        return warehouseType;
    }

    public void setWarehouseType(Integer warehouseType) {
        this.warehouseType = warehouseType;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public WarehouseType getWarehouseTypeClass() {
        return warehouseTypeClass;
    }

    public void setWarehouseTypeClass(WarehouseType warehouseTypeClass) {
        this.warehouseTypeClass = warehouseTypeClass;
    }
}
