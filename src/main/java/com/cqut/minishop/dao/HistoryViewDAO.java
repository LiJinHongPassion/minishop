package com.cqut.minishop.dao;

import com.cqut.minishop.entity.HistoryView;
import org.springframework.stereotype.Repository;

/**
 * HistoryViewDAO继承基类
 */
@Repository
public interface HistoryViewDAO extends MyBatisBaseDao<HistoryView, String> {
}