package com.cqut.minishop.dao;

import com.cqut.minishop.entity.Merchants;
import org.springframework.stereotype.Repository;

/**
 * MerchantsDAO继承基类
 */
@Repository
public interface MerchantsDAO extends MyBatisBaseDao<Merchants, String> {
}