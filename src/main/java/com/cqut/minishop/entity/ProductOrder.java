package com.cqut.minishop.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * product_order
 * @author 
 */
public class ProductOrder implements Serializable {
    /**
     * id
     */
    private String poId;

    /**
     * user_id
     */
    private String poUserId;

    /**
     * 商品id
     */
    private String poProductId;

    /**
     * 商品数量
     */
    private Integer poNum;

    /**
     * 总价
     */
    private Long poPrice;

    /**
     * order创建时间
     */
    private Date poStartTime;

    /**
     * order完成时间
     */
    private Date poFinishTime;

    /**
     * i:已付款 0：未付款
     */
    private Byte poStatus;

    /**
     * 1：已发货 2：未发货 0：已签收 
     */
    private Integer productStatus;

    /**
     * 商品价格
     */
    private BigDecimal productPrice;

    private static final long serialVersionUID = 1L;

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getPoUserId() {
        return poUserId;
    }

    public void setPoUserId(String poUserId) {
        this.poUserId = poUserId;
    }

    public String getPoProductId() {
        return poProductId;
    }

    public void setPoProductId(String poProductId) {
        this.poProductId = poProductId;
    }

    public Integer getPoNum() {
        return poNum;
    }

    public void setPoNum(Integer poNum) {
        this.poNum = poNum;
    }

    public Long getPoPrice() {
        return poPrice;
    }

    public void setPoPrice(Long poPrice) {
        this.poPrice = poPrice;
    }

    public Date getPoStartTime() {
        return poStartTime;
    }

    public void setPoStartTime(Date poStartTime) {
        this.poStartTime = poStartTime;
    }

    public Date getPoFinishTime() {
        return poFinishTime;
    }

    public void setPoFinishTime(Date poFinishTime) {
        this.poFinishTime = poFinishTime;
    }

    public Byte getPoStatus() {
        return poStatus;
    }

    public void setPoStatus(Byte poStatus) {
        this.poStatus = poStatus;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}