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
    public static final int GLOBAL_NORMAL_STATUS_INT =  200 ;
    public static final int GLOBAL_ERROR_STATUS_INT =  500 ;

    //验证码有效时间 3分钟
    public static final long VERIFICATION_CODE_TIMA = 60 * 3;

    //用户头像保存文件名
    public static final String USRE_PIC_PATH = "upload";
    //图片ip地址前缀
    public static final String IP_PORT_ADDRESS = "http://localhost:8080/minishop";


}