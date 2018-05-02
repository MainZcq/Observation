package com.zcq.springbootobservation.Entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement( name = "product" )
public class GF3Type {

    int segmentID;
    int sceneID;
    Sensor sensor;

    public GF3Type() {
    }

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
