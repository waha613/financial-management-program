package com.fms2.fms2.receivableAndPayable.domain;

public class AccountReceivable {
    private Long receiveId;
    private String receiveDate;
    private String warehouse;
    private Double actualSales;//实际上是actualReceive
    private String receiveMethod;
    private String comment;

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Double getActualSales() {
        return actualSales;
    }

    public void setActualSales(Double actualSales) {
        this.actualSales = actualSales;
    }

    public String getReceiveMethod() {
        return receiveMethod;
    }

    public void setReceiveMethod(String receiveMethod) {
        this.receiveMethod = receiveMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
