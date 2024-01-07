package com.java.pojo;

import java.util.List;

public class PageBean<T> {
    private int total;

    private List<T> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
