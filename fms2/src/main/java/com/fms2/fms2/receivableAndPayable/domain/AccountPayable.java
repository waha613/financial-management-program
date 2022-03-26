package com.fms2.fms2.receivableAndPayable.domain;

public class AccountPayable {
    private Integer payID;
    private String payDate;
    private String supplier;
    private Double amountOfThisPurchase;
    private String paymentMethod;
    private String comment;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPayID() {
        return payID;
    }

    public void setPayID(Integer payID) {
        this.payID = payID;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Double getAmountOfThisPurchase() {
        return amountOfThisPurchase;
    }

    public void setAmountOfThisPurchase(Double amountOfThisPurchase) {
        this.amountOfThisPurchase = amountOfThisPurchase;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
