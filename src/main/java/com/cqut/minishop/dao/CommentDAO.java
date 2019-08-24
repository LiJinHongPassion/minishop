package com.cqut.minishop.dao;

import com.cqut.minishop.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * CommentDAO继承基类
 */
@Repository
public interface CommentDAO extends MyBatisBaseDao<Comment, String> {
}