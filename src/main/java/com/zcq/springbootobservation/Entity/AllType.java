package com.zcq.springbootobservation.Entity;

public class AllType {
    //产品表
    private String productID;
    //卫星编号
    private String satelliteID;
    //传感器编号
    private String sensorID;
    private String sceneID;
    //采集时间
    private String produceTime;
    private String produceTime1;
    private String level;
    private String nominalResolution;
    private String  imagingMode;
    private String  cloudPercent;
    //城市信息表
    private String province;
    private String city;
    private String county;
    //经纬度
    private String leftTopLng;
    private String leftTopLat;
    private String rightBottomLng;
    private String rightBottomLat;
    //路径
    private String address;

    public String getProduceTime1() {
        return produceTime1;
    }

    public void setProduceTime1(String produceTime1) {
        this.produceTime1 = produceTime1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getCloudPercent() {
        return cloudPercent;
    }

    public void setCloudPercent(String cloudPercent) {
        this.cloudPercent = cloudPercent;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLeftTopLng() {
        return leftTopLng;
    }

    public void setLeftTopLng(String leftTopLng) {
        this.leftTopLng = leftTopLng;
    }

    public String getLeftTopLat() {
        return leftTopLat;
    }

    public void setLeftTopLat(String leftTopLat) {
        this.leftTopLat = leftTopLat;
    }

    public String getRightBottomLng() {
        return rightBottomLng;
    }

    public void setRightBottomLng(String rightBottomLng) {
        this.rightBottomLng = rightBottomLng;
    }

    public String getRightBottomLat() {
        return rightBottomLat;
    }

    public void setRightBottomLat(String rightBottomLat) {
        this.rightBottomLat = rightBottomLat;
    }

    public String getSceneID() {
        return sceneID;
    }

    public void setSceneID(String sceneID) {
        this.sceneID = sceneID;
    }
}
