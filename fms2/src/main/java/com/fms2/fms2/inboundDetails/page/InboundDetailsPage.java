package com.fms2.fms2.inboundDetails.page;

import com.fms2.fms2.page.BasePage;

import java.util.List;

public class InboundDetailsPage extends BasePage {
    private Long inboundId;
    private String inboundDate;
    private String supplier;
    private String productID;
    private String unit;
    private Double unitPrice;
    private Integer inboundQuantity;
    private Double amountOfThisPurchase;
    private Double purchaseFee;
    private String purchaseFeeType;
    private Double actualPayment;
    private String warehouse;
    private String comment;
    private String inboundStartDate;
    private String inboundEndDate;
    private String sort = "inboundDate";
    private String dir = "desc";
    private int statistics;
    private List<String> inboundIds;

    public List<String> getInboundIds() {
        return inboundIds;
    }

    public void setInboundIds(List<String> inboundIds) {
        this.inboundIds = inboundIds;
    }

    public int getStatistics() {
        return statistics;
    }

    public void setStatistics(int statistics) {
        this.statistics = statistics;
    }

    public String getPurchaseFeeType() {
        return purchaseFeeType;
    }

    public void setPurchaseFeeType(String purchaseFeeType) {
        this.purchaseFeeType = purchaseFeeType;
    }

    public Long getInboundId() {
        return inboundId;
    }

    public void setInboundId(Long inboundId) {
        this.inboundId = inboundId;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getInboundQuantity() {
        return inboundQuantity;
    }

    public void setInboundQuantity(Integer inboundQuantity) {
        this.inboundQuantity = inboundQuantity;
    }

    public Double getAmountOfThisPurchase() {
        return amountOfThisPurchase;
    }

    public void setAmountOfThisPurchase(Double amountOfThisPurchase) {
        this.amountOfThisPurchase = amountOfThisPurchase;
    }

    public Double getPurchaseFee() {
        return purchaseFee;
    }

    public void setPurchaseFee(Double purchaseFee) {
        this.purchaseFee = purchaseFee;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInboundStartDate() {
        return inboundStartDate;
    }

    public void setInboundStartDate(String inboundStartDate) {
        this.inboundStartDate = inboundStartDate;
    }

    public String getInboundEndDate() {
        return inboundEndDate;
    }

    public void setInboundEndDate(String inboundEndDate) {
        this.inboundEndDate = inboundEndDate;
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
}
