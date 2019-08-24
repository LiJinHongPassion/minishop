package com.cqut.minishop.entity;

import java.io.Serializable;

/**
 * shop_car
 * @author 
 */
public class ShopCar implements Serializable {
    private String scId;

    private String scUserId;

    private String scProductId;

    private Integer scNum;

    private String scAttribute;

    private static final long serialVersionUID = 1L;

    public String getScId() {
        return scId;
    }

    public void setScId(String scId) {
        this.scId = scId;
    }

    public String getScUserId() {
        return scUserId;
    }

    public void setScUserId(String scUserId) {
        this.scUserId = scUserId;
    }

    public String getScProductId() {
        return scProductId;
    }

    public void setScProductId(String scProductId) {
        this.scProductId = scProductId;
    }

    public Integer getScNum() {
        return scNum;
    }

    public void setScNum(Integer scNum) {
        this.scNum = scNum;
    }

    public String getScAttribute() {
        return scAttribute;
    }

    public void setScAttribute(String scAttribute) {
        this.scAttribute = scAttribute;
    }
}