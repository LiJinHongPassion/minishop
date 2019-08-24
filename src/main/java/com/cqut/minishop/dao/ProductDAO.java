package com.cqut.minishop.dao;

import com.cqut.minishop.entity.Product;
import org.springframework.stereotype.Repository;

/**
 * ProductDAO继承基类
 */
@Repository
public interface ProductDAO extends MyBatisBaseDao<Product, String> {
}