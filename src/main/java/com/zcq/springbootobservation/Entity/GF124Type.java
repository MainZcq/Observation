package com.zcq.springbootobservation.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement( name = "ProductMetaData" )
public class GF124Type {

    String productID;
    String satelliteID;
    String sensorID;
    String sceneID;
    String productLevel;
    String produceTime;
    String cloudPercent;
    String topLeftLatitude;
    String topLeftLongitude;
    String bottomRightLatitude;
    String bottomRightLongitude;

    public GF124Type() {
    }


    @XmlElement( name = "ProductID" )
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getProductID() {
        return productID;
    }

    @XmlElement(name="SatelliteID")
    public void setSatellite(String satelliteID){this.satelliteID = satelliteID;}

    public String getSatellite(){return  satelliteID;}

    @XmlElement(name = "SceneID")
    public void setSceneID(String sceneID) {
        this.sceneID = sceneID;
    }

    public String getSceneID() {
        return sceneID;
    }

    @XmlElement(name="SensorID")
    public void setSensorID(String sensorID) {
        this.sensorID = sensorID;
    }

    public String getSensorID() {
        return sensorID;
    }

    @XmlElement(name="ProductLevel")
    public void setProductLevel(String productLevel) {
        this.productLevel = productLevel;
    }

    public String getProductLevel() {
        return productLevel;
    }

    @XmlElement(name="ProduceTime")
    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getProduceTime() {
        return produceTime;
    }

    @XmlElement(name="CloudPercent")
    public void setCloudPercent(String cloudPercent) {
        this.cloudPercent = cloudPercent;
    }

    public String getCloudPercent() {
        return cloudPercent;
    }

    @XmlElement(name="TopLeftLatitude")
    public void setTopLeftLatitude(String topLeftLatitude) {
        this.topLeftLatitude = topLeftLatitude;
    }

    public String getTopLeftLatitude() {
        return topLeftLatitude;
    }

    @XmlElement(name="TopLeftLongitude")
    public void setTopLeftLongitude(String topLeftLongitude) {
        this.topLeftLongitude = topLeftLongitude;
    }

    public String getTopLeftLongitude() {
        return topLeftLongitude;
    }

    @XmlElement(name="BottomRightLatitude")
    public void setBottomRightLatitude(String bottomRightLatitude) {
        this.bottomRightLatitude = bottomRightLatitude;
    }

    public String getBottomRightLatitude() {
        return bottomRightLatitude;
    }

    @XmlElement(name="BottomRightLongitude")
    public void setBottomRightLongitude(String bottomRightLongitude) {
        this.bottomRightLongitude = bottomRightLongitude;
    }

    public String getBottomRightLongitude() {
        return bottomRightLongitude;
    }
}
