package com.cqut.minishop.util.verificationcode;

import java.util.ArrayList;
import java.util.List;

import static com.cqut.minishop.comment.Constants.VERIFICATION_CODE_TIMA;

/**
 * 描述：邮箱验证码
 * @author LJH
 * @date 2019/8/29-15:15
 * @QQ 1755497577
 */
public class VerificationCodeUtils {

    private static List<VerificationCode> codeList = new ArrayList<>();

    /**
     * 描述: 获取验证码，并将验证码保存至内存
     *
     * @author LJH-1755497577 2019/8/29 15:36
     * @param userName 用户名
     * @return java.lang.String 返回验证码
     */
    public static String getCode(String userName){
        for( int a = 0; a < codeList.size(); a++ ){
            VerificationCode c = codeList.get(a);
            if ( c.getUserName().equals(userName)){
                codeList.remove(a);
            }
        }

        VerificationCode c = new VerificationCode(userName);
        codeList.add(c);
        return c.getCode();
    }

    /**
     * 描述: 验证验证码是否正确
     *       正确：移除验证码，返回true
     *       错误：移除验证码，返回false
     *       未找到：返回false
     *
     * @author LJH-1755497577 2019/8/29 15:45
     * @param userName 用户名
     * @param code 验证码
     * @return boolean 成功：true   失败：false
     */
    public static boolean verify(String userName, String code){

        for( int a = 0; a < codeList.size(); a++ ){
            VerificationCode c = codeList.get(a);
            if ( c.getUserName().equals(userName)){
                if (c.getCode().equals(code)){
                    codeList.remove(a);
                    return true;
                }
                codeList.remove(a);
                return false;
            }
        }
        return false;
    }


    /**
     * 描述: 判断验证码是否过期
     *      未过期：回true
     *      过期：移除验证码，返回false
     *      未找到：返回false
     *
     * @author LJH-1755497577 2019/8/29 16:07
     * @param userName
     * @return boolean
     */
    public static boolean verifyTime(String userName){
        long temp_time = System.currentTimeMillis() / 1000;
        for( int a = 0; a < codeList.size(); a++ ){
            VerificationCode c = codeList.get(a);
            if ( c.getUserName().equals(userName)){
                System.out.println(temp_time - c.getTime());
                if ( temp_time - c.getTime() > 30
                        && temp_time - c.getTime() < VERIFICATION_CODE_TIMA){
                    return true;
                }
                codeList.remove(a);
                return false;
            }
        }
        return false;
    }

}
