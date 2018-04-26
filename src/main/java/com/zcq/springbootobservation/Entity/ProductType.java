package com.zcq.springbootobservation.Entity;

public class ProductType {

    private String productID;
    //卫星编号
    private String satelliteID;
    //传感器编号
    private String sensorID;
    //采集时间
    private String produceTime;

    private String nominalResolution;

    private String  imagingMode;

    private String  level;

    private String  cloudPercent;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getSatelliteID() {
        return satelliteID;
    }

    public void setSatelliteID(String satelliteID) {
        this.satelliteID = satelliteID;
    }

    public String getSensorID() {
        return sensorID;
    }

    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getNominalResolution() {
        return nominalResolution;
    }

    public void setNominalResolution(String nominalResolution) {
        this.nominalResolution = nominalResolution;
    }

    public String getImagingMode() {
        return imagingMode;
    }

    public void setImagingMode(String imagingMode) {
        this.imagingMode = imagingMode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCloudPercent() {
        return cloudPercent;
    }

    public void setCloudPercent(String cloudPercent) {
        this.cloudPercent = cloudPercent;
    }
}
