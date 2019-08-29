package com.cqut.minishop.dao;

import com.cqut.minishop.entity.User;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Repository
public interface UserDAO extends MyBatisBaseDao<User, String> {
    User selectByUserName(String userName);

    void changeStatus(String userId, int status);
}