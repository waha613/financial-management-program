package com.fms2.fms2.outboundDetails.page;

import com.fms2.fms2.page.BasePage;

public class OutboundDetailPage extends BasePage {
    private Long outboundId;
    private String outboundDate;
    private String warehouse;
    private String productID;
    private String unit;
    private Double unitSalePrice;
    private Integer outboundQuantity;
    private Double amountOfThisSale;
    private Double saleFee;
    private String saleFeeType;
    private Double actualSales;
    private String comment;

    private String outboundStartDate;
    private String outboundEndDate;
    private String sort = "outboundDate";
    private String dir = "desc";

    public String getOutboundStartDate() {
        return outboundStartDate;
    }

    public void setOutboundStartDate(String outboundStartDate) {
        this.outboundStartDate = outboundStartDate;
    }

    public String getOutboundEndDate() {
        return outboundEndDate;
    }

    public void setOutboundEndDate(String outboundEndDate) {
        this.outboundEndDate = outboundEndDate;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Long getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Long outboundId) {
        this.outboundId = outboundId;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitSalePrice() {
        return unitSalePrice;
    }

    public void setUnitSalePrice(Double unitSalePrice) {
        this.unitSalePrice = unitSalePrice;
    }

    public Integer getOutboundQuantity() {
        return outboundQuantity;
    }

    public void setOutboundQuantity(Integer outboundQuantity) {
        this.outboundQuantity = outboundQuantity;
    }

    public Double getAmountOfThisSale() {
        return amountOfThisSale;
    }

    public void setAmountOfThisSale(Double amountOfThisSale) {
        this.amountOfThisSale = amountOfThisSale;
    }

    public Double getSaleFee() {
        return saleFee;
    }

    public void setSaleFee(Double saleFee) {
        this.saleFee = saleFee;
    }

    public String getSaleFeeType() {
        return saleFeeType;
    }

    public void setSaleFeeType(String saleFeeType) {
        this.saleFeeType = saleFeeType;
    }

    public Double getActualSales() {
        return actualSales;
    }

    public void setActualSales(Double actualSales) {
        this.actualSales = actualSales;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
