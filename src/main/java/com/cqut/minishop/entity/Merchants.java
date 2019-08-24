package com.cqut.minishop.entity;

import java.io.Serializable;

/**
 * merchants
 * @author 
 */
public class Merchants implements Serializable {
    private String mid;

    private static final long serialVersionUID = 1L;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}