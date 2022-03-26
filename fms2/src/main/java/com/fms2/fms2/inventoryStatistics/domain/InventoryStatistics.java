package com.fms2.fms2.inventoryStatistics.domain;

public class InventoryStatistics {
    private String warehouse;
    private String productID;
    private String inboundStartDate;
    private String inboundEndDate;
    private Integer inboundQuantity;
    private Double amountOfThisPurchase;
    private Double purchaseFee;
    private Double actualPayment;
    private Integer outboundQuantity;
    private Double amountOfThisSale;
    private Double actualSales;
    private Double profit;

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

    public Double getActualSales() {
        return actualSales;
    }

    public void setActualSales(Double actualSales) {
        this.actualSales = actualSales;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }
}
