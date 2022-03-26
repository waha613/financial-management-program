package com.fms2.fms2.inventoryStatistics.domain;

import com.fms2.fms2.inboundDetails.page.InboundDetailsPage;

public class InboundDetailStatistics extends InboundDetailsPage {
    private String supplier;
    private String warehouse;
    private String productID;
    private Integer inboundQuantity;
    private Double amountOfThisPurchase;
    private Double purchaseFee;
    private Double actualPayment;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
}
