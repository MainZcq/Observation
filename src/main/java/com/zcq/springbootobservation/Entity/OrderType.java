package com.zcq.springbootobservation.Entity;

public class OrderType {
    private String orderId;
    private String productID;
    private String username;
    private String realname;
    private String satelliteID;
    private String sensorID;
    private String leftTopLng;
    private String leftTopLat;
    private String rightBottomLng;
    private String rightBottomLat;
    private String level;
    private String produceTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productID;
    }

    public void setProductId(String productID) {
        this.productID = productID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }
}
