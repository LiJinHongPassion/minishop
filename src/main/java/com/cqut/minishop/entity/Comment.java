package com.cqut.minishop.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * comment
 * @author 
 */
public class Comment implements Serializable {
    private String cId;

    private String cUserId;

    private String cProductId;

    private String cOrderId;

    private Date cTime;

    private static final long serialVersionUID = 1L;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId;
    }

    public String getcProductId() {
        return cProductId;
    }

    public void setcProductId(String cProductId) {
        this.cProductId = cProductId;
    }

    public String getcOrderId() {
        return cOrderId;
    }

    public void setcOrderId(String cOrderId) {
        this.cOrderId = cOrderId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}