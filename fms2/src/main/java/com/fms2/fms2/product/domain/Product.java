package com.fms2.fms2.product.domain;

public class Product {
    private String productID;
    private String productName;
    private String standard;
    private Integer itemQuantity;
    private Double oneItemWeight;
    private Integer oneProductWeight;
    private String unit;

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public Double getOneItemWeight() {
        return oneItemWeight;
    }

    public void setOneItemWeight(Double oneItemWeight) {
        this.oneItemWeight = oneItemWeight;
    }

    public Integer getOneProductWeight() {
        return oneProductWeight;
    }

    public void setOneProductWeight(Integer oneProductWeight) {
        this.oneProductWeight = oneProductWeight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", standard='" + standard + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", oneItemWeight=" + oneItemWeight +
                ", oneProductWeight=" + oneProductWeight +
                ", unit='" + unit + '\'' +
                '}';
    }
}
