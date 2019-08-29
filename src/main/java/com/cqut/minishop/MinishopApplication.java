package com.cqut.minishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 描述: 启动类
 *
 * @author LJH-1755497577 2019/8/29 16:23
 */
@SpringBootApplication
@MapperScan("com.cqut.minishop.dao")//将项目中对应的mapper类的路径加进来就可以了
public class MinishopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinishopApplication.class, args);
    }

}
