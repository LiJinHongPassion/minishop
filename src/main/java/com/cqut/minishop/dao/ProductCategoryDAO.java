package com.cqut.minishop.dao;

import com.cqut.minishop.entity.ProductCategory;
import org.springframework.stereotype.Repository;

/**
 * ProductCategoryDAO继承基类
 */
@Repository
public interface ProductCategoryDAO extends MyBatisBaseDao<ProductCategory, String> {
}