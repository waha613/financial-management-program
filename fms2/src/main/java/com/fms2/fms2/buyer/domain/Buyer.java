package com.fms2.fms2.buyer.domain;

import java.util.List;

public class Buyer {
    private String buyerName;
    private String warehouse;
    private List<String> childrenWarehouse;

    public List<String> getChildrenWarehouse() {
        return childrenWarehouse;
    }

    public void setChildrenWarehouse(List<String> childrenWarehouse) {
        this.childrenWarehouse = childrenWarehouse;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
