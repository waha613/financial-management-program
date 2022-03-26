package com.fms2.fms2.receivableAndPayable.page;

import com.fms2.fms2.page.BasePage;

public class AccountReceivablePage extends BasePage {
    private Long receiveId;
    private String receivableDate;
    private String warehouse;
    private Double actualSales;
    private String receiveMethod;
    private String comment;

    private String receiveStartDate;
    private String receiveEndDate;
    private String sort = "receiveDate";
    private String dir = "desc";

    public String getReceiveStartDate() {
        return receiveStartDate;
    }

    public void setReceiveStartDate(String receiveStartDate) {
        this.receiveStartDate = receiveStartDate;
    }

    public String getReceiveEndDate() {
        return receiveEndDate;
    }

    public void setReceiveEndDate(String receiveEndDate) {
        this.receiveEndDate = receiveEndDate;
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

    public Long getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(String receivableDate) {
        this.receivableDate = receivableDate;
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
