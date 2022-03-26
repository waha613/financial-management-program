package com.fms2.fms2.page;

public abstract class BasePage {
    //分页时输入的参数
    private int page = 1;//当前页
    private int limit = 16;//一页显示的行数

    private int pageCount;

    //写分页SQL时需要的条件由输入参数计算而来
    private int begin;//当前页的起始行

    //用于计算总行数
    private int rows;

    public int getPageCount() {
        if (this.rows % limit == 0) {
            this.pageCount = this.rows / limit;
        } else {
            this.pageCount = (this.rows / limit) + 1;
        }
        return this.pageCount;
    }

    public int getBegin() {
        begin = (page - 1) * limit;
        return begin;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getRows() {
        return this.rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
