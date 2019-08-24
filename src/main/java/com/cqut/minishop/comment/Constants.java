package com.cqut.minishop.comment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 常量类
 */
@Component
public class Constants {

    /**
     *     全局默认状态，包括正常、异常、删除的数字和字符串
     */
    public static final int GLOBAL_NORMAL_STATUS_INT =  1 ;
    public static final int GLOBAL_ERROR_STATUS_INT =  0 ;

}