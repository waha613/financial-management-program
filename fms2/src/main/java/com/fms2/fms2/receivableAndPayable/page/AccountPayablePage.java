package com.fms2.fms2.receivableAndPayable.page;

import com.fms2.fms2.page.BasePage;

public class AccountPayablePage extends BasePage {
    private Integer payID;
    private String payDate;
    private String supplier;
    private Double amountOfThisPurchase;
    private String paymentMethod;
    private String comment;
    private String payStartDate;
    private String payEndDate;
    private String sort = "payDate";
    private String dir = "desc";

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

    public String getPayStartDate() {
        return payStartDate;
    }

    public void setPayStartDate(String payStartDate) {
        this.payStartDate = payStartDate;
    }

    public String getPayEndDate() {
        return payEndDate;
    }

    public void setPayEndDate(String payEndDate) {
        this.payEndDate = payEndDate;
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
