package com.cqut.minishop.entity;

import java.io.Serializable;

/**
 * product_category
 * @author 
 */
public class ProductCategory implements Serializable {
    /**
     * 商品分类
     */
    private String pcId;

    /**
     * 分类名
     */
    private String pcName;

    /**
     * 二级分类
     */
    private String pcNextId;

    private static final long serialVersionUID = 1L;

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getPcName() {
        return pcName;
    }

    public void setPcName(String pcName) {
        this.pcName = pcName;
    }

    public String getPcNextId() {
        return pcNextId;
    }

    public void setPcNextId(String pcNextId) {
        this.pcNextId = pcNextId;
    }
}