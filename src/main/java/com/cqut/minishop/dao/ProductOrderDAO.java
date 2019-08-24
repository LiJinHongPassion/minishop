package com.cqut.minishop.dao;

import com.cqut.minishop.entity.ProductOrder;
import org.springframework.stereotype.Repository;

/**
 * ProductOrderDAO继承基类
 */
@Repository
public interface ProductOrderDAO extends MyBatisBaseDao<ProductOrder, String> {
}