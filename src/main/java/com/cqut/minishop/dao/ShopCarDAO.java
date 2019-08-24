package com.cqut.minishop.dao;

import com.cqut.minishop.entity.ShopCar;
import org.springframework.stereotype.Repository;

/**
 * ShopCarDAO继承基类
 */
@Repository
public interface ShopCarDAO extends MyBatisBaseDao<ShopCar, String> {
}