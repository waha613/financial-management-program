package com.fms2.fms2.receivableAndPayable.domain;

public class PayableStatistics {
    private String supplier;
    private String startDate;
    private String endDate;
    private Double purchaseAmount;
    private Double actualPayment;
    private Double balance;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
      this.balance = balance;
    }
}
