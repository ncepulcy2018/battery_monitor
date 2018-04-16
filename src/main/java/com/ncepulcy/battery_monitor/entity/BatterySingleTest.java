package com.ncepulcy.battery_monitor.entity;

public class BatterySingleTest {
    private String groupID;
    private String batteryID;
    private Float startU;
    private Float endU;
    private String serialNumber;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getBatteryID() {
        return batteryID;
    }

    public void setBatteryID(String batteryID) {
        this.batteryID = batteryID;
    }

    public Float getStartU() {
        return startU;
    }

    public void setStartU(Float startU) {
        this.startU = startU;
    }

    public Float getEndU() {
        return endU;
    }

    public void setEndU(Float endU) {
        this.endU = endU;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
