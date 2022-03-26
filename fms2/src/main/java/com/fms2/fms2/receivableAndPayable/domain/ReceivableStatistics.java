package com.fms2.fms2.receivableAndPayable.domain;

public class ReceivableStatistics {
    private String warehouse;
    private String startDate;
    private String endDate;
    private Double actualSales;
    private Double actualReceive;
    private Double balance;

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
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

    public Double getActualSales() {
        return actualSales;
    }

    public void setActualSales(Double actualSales) {
        this.actualSales = actualSales;
    }

    public Double getActualReceive() {
        return actualReceive;
    }

    public void setActualReceive(Double actualReceive) {
        this.actualReceive = actualReceive;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
