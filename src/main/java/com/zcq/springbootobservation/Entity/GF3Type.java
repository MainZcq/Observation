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

    String productID;
    int segmentID;
    String sceneID;
    String satellite;
    productInfo pi;
    Sensor sensor;
    ImageInfo imageInfo;
    public GF3Type() {
    }


    @XmlElement( name = "productID" )
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public String getProductID() {
        return productID;
    }
    /**
     * 内部类, 使用jaxb时必须使用static
     */
    @XmlRootElement( name = "sensor" )
    private static class Sensor {
        private String sensorID;
        private String imagingMode;

        @XmlElement(name="sensorID")
        public void setSensorID(String sensorID) {
            this.sensorID = sensorID;
        }

        public String getSensorID() {
            return sensorID;
        }

        @XmlElement(name="imagingMode")
        public void setImagingMode(String imagingMode) {
            this.imagingMode = imagingMode;
        }

        public String getImagingMode() {
            return imagingMode;
        }
    };

    @XmlRootElement( name = "productinfo" )
    private static class productInfo {
        private String nominalResolution;
        private String productLevel;
        private String productGentime;

        @XmlElement(name="NominalResolution")
        public void setNominalResolution(String nominalResolution) {
            this.nominalResolution = nominalResolution;
        }

        public String getNominalResolution() {
            return nominalResolution;
        }

        @XmlElement(name="productLevel")
        public void setProductLevel(String productLevel) {
            this.productLevel = productLevel;
        }

        public String getProductLevel() {
            return productLevel;
        }

        @XmlElement(name="productGentime")
        public void setProductGentime(String productGentime) {
            this.productGentime = productGentime;
        }

        public String getProductGentime() {
            return productGentime;
        }
    };

    @XmlRootElement( name = "imageinfo" )
    private static class ImageInfo {
        private Corner corner;

        public Corner getCorner() {
            return corner;
        }
        @XmlElement(name="corner")
        public void setCorner(Corner corner) {
            this.corner = corner;
        }

        public String getTopLeftLat() {
            return corner.getTopLeftLat();
        }
        public String getTopLeftLng() {
            return corner.getTopLeftLng();
        }

        public String getBottomRightLat() {
            return corner.getBottomRightLat();
        }
        public String getBottomRightLng() {
            return corner.getBottomRightLat();
        }

        @XmlRootElement( name = "corner" )
        private static class Corner {
            private TopLeft topLeft;
            private BottomRight bottomRight;


            @XmlElement(name="topLeft")
            public void setTopLeft(TopLeft topLeft) {
                this.topLeft = topLeft;
            }
            @XmlElement(name="bottomRight")
            public void setBottomRight(BottomRight bottomRight) {
                this.bottomRight = bottomRight;
            }

            public String getTopLeftLat() {
                return topLeft.getLatitude();
            }
            public String getTopLeftLng() {
                return topLeft.getLongitude();
            }

            public String getBottomRightLat() {
                return bottomRight.getLatitude();
            }
            public String getBottomRightLng() {
                return bottomRight.getLongitude();
            }

            @XmlRootElement( name = "topLeft" )
            private static class TopLeft {
                private String latitude;
                private String longitude;

                public String getLatitude() {
                    return latitude;
                }
                @XmlElement(name="latitude")
                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }
                @XmlElement(name="longitude")
                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            };

            @XmlRootElement( name = "bottomRight" )
            private static class BottomRight {
                private String latitude;
                private String longitude;

                public String getLatitude() {
                    return latitude;
                }
                @XmlElement(name="latitude")
                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getLongitude() {
                    return longitude;
                }
                @XmlElement(name="longitude")
                public void setLongitude(String longitude) {
                    this.longitude = longitude;
                }
            };
        };
    };
    @XmlElement( name = "sensor" )
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getSensorID() {
        return sensor.getSensorID();
    }

    public String getImagingMode() {
        return sensor.getImagingMode();
    }

    @XmlElement( name = "productinfo" )
    public void setProductInfo(productInfo productInfo) {
        this.pi = productInfo;
    }

    public String getProductLevel(){
        return pi.getProductLevel();
    }

    public String getProductGentime() {

        return pi.getProductGentime();
    }
    public String getNominalResolution(){
        return pi.getNominalResolution();
    }

    @XmlElement( name = "imageinfo" )
    public void setImageInfo(ImageInfo ImageInfo) {
        this.imageInfo = ImageInfo;
    }

    public String getTopLeftLat() {
        return imageInfo.getTopLeftLat();
    }
    public String getTopLeftLng() {
        return imageInfo.getTopLeftLng();
    }

    public String getBottomRightLat() {
        return imageInfo.getBottomRightLat();
    }
    public String getBottomRightLng() {
        return imageInfo.getBottomRightLat();
    }

    @XmlElement(name = "sceneID")
    public void setSceneID(String sceneID) {
        this.sceneID = sceneID;
    }

    public String getSceneID() {
        return sceneID;
    }

    @XmlElement(name="segmentID")
    public void setSegmentID(int segmentID) {
        this.segmentID = segmentID;
    }

    public int getSegmentID() {
        return segmentID;
    }

    @XmlElement(name="satellite")
    public void setSatellite(String satellite){this.satellite = satellite;}

    public String getSatellite(){return  satellite;}



}
