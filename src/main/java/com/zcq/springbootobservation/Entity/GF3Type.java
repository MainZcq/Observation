package com.zcq.springbootobservation.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 代码学习自: https://examples.javacodegeeks.com/core-java/xml/bind/jaxb-unmarshal-example/
 *
 * 样例xml
 * <?xml version="1.0" encoding="UTF-8" standalone="yes" ?>
 * <product>
 *     <segmentID>188619</segmentID>
 *     <sceneID>4845210</sceneID>
 *     <sensor>
 *         <sensorID>SAR</sensorID>
 *         <imagingMode>FSII</imagingMode>
 *  ...
 *
 *
 * 解析后的数据结构:
 *
 * GF3Type:
 *   segmentID,
 *   sceneID,
 *   sensor: {sensorID, imagingMode}
 *
 */



@XmlRootElement( name = "product" )
public class GF3Type {

    int segmentID;
    int sceneID;
    Sensor sensor;

    public GF3Type() {
    }

    /**
     * 内部类, 使用jaxb时必须使用static
     */
    @XmlRootElement( name = "sensor" )
    private static class Sensor {
        private String sensorID;
        private int lambda;

        @XmlElement(name="lambda")
        public void setLambda(int lambda) {
            this.lambda = lambda;
        }

        @XmlElement(name="sensorID")
        public void setSensorID(String sensorID) {
            this.sensorID = sensorID;
        }

        public String getSensorID() {
            return sensorID;
        }

        public int getLambda() {
            return lambda;
        }
    };

    @XmlElement( name = "sensor" )
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public int getSceneID() {
        return sceneID;
    }

    public String getSensorID() {
        return sensor.getSensorID();
    }

    @XmlElement(name="segmentID")
    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

    public int getSegmentID() {
        return segmentID;
    }
}
