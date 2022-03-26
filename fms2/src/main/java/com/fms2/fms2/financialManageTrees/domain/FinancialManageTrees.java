package com.fms2.fms2.financialManageTrees.domain;

import java.util.ArrayList;
import java.util.List;

public class FinancialManageTrees {
    private String id;
    private String parentId;
    private String name;
    private Boolean leaf;
    private Boolean expanded;
    private String href;
    private List<FinancialManageTrees> children = new ArrayList<FinancialManageTrees>();

    public List<FinancialManageTrees> getChildren() {
        return children;
    }

    public void setChildren(List<FinancialManageTrees> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }
}
