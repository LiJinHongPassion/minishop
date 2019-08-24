package com.cqut.minishop.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author LJH
 * @date 2019/6/17-22:52
 *
 * 需要添加依赖
 * <!-- https://mvnrepository.com/artifact/org.apache.shiro/shiro-core -->
 *     <dependency>
 *       <groupId>org.apache.shiro</groupId>
 *       <artifactId>shiro-core</artifactId>
 *       <version>1.2.3</version>
 *     </dependency>
 */
public class MD5Utils {
    private final static Integer HASH_NUM = 100;

    /**
     * 加密工具
     * @param pwd
     * @param salt
     * @return
     */
    public static Md5Hash getMd5Hash(String pwd, String salt){
        return new Md5Hash(pwd, salt, HASH_NUM);
    }
}
