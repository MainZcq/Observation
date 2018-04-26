package com.zcq.springbootobservation.Entity;

public class LngAndLatType {
    private String productId;
    private String leftTopLng;
    private String leftTopLat;
    private String rightBottomLng;
    private String rightBottomLat;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    @Override
    public String toString() {
        return "LngAndLatType{" +
                "productId='" + productId + '\'' +
                ", leftTopLng='" + leftTopLng + '\'' +
                ", leftTopLat='" + leftTopLat + '\'' +
                ", rightBottomLng='" + rightBottomLng + '\'' +
                ", rightBottomLat='" + rightBottomLat + '\'' +
                '}';
    }
}
