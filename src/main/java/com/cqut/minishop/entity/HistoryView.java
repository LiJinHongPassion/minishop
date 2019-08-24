package com.cqut.minishop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * history_view
 * @author 
 */
public class HistoryView implements Serializable {
    private String hvUserId;

    private String hvProductsId;

    private Date hvTime;

    private static final long serialVersionUID = 1L;

    public String getHvUserId() {
        return hvUserId;
    }

    public void setHvUserId(String hvUserId) {
        this.hvUserId = hvUserId;
    }

    public String getHvProductsId() {
        return hvProductsId;
    }

    public void setHvProductsId(String hvProductsId) {
        this.hvProductsId = hvProductsId;
    }

    public Date getHvTime() {
        return hvTime;
    }

    public void setHvTime(Date hvTime) {
        this.hvTime = hvTime;
    }
}