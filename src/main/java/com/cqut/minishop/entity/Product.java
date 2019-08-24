package com.cqut.minishop.entity;

import java.io.Serializable;

/**
 * product
 * @author 
 */
public class Product implements Serializable {
    /**
     * id
     */
    private String pId;

    /**
     * 名称
     */
    private String pName;

    /**
     * 价格
     */
    private Long pPrice;

    /**
     * 库存
     */
    private Integer pRepertory;

    /**
     * 图片
     */
    private String pPic;

    /**
     * 产品类别
     */
    private String pCategoryId;

    /**
     * 详细信息
     */
    private String pDetailinfo;

    /**
     * 状态 1：上架 0：下架
     */
    private Byte pStatus;

    /**
     * 商品地址
     */
    private String pAddress;

    /**
     * 分类
     */
    private String pClassification;

    /**
     * 二级分类
     */
    private String pNextClassification;

    private static final long serialVersionUID = 1L;

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getpPrice() {
        return pPrice;
    }

    public void setpPrice(Long pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpRepertory() {
        return pRepertory;
    }

    public void setpRepertory(Integer pRepertory) {
        this.pRepertory = pRepertory;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public String getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(String pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public String getpDetailinfo() {
        return pDetailinfo;
    }

    public void setpDetailinfo(String pDetailinfo) {
        this.pDetailinfo = pDetailinfo;
    }

    public Byte getpStatus() {
        return pStatus;
    }

    public void setpStatus(Byte pStatus) {
        this.pStatus = pStatus;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpClassification() {
        return pClassification;
    }

    public void setpClassification(String pClassification) {
        this.pClassification = pClassification;
    }

    public String getpNextClassification() {
        return pNextClassification;
    }

    public void setpNextClassification(String pNextClassification) {
        this.pNextClassification = pNextClassification;
    }
}