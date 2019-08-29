package com.cqut.minishop.util.verificationcode;

import java.util.Random;

public class VerificationCode{

    //用户名
    private String userName;

    //验证码
    private String code;

    //时间
    private long time;

    public VerificationCode(String userName){
        this.userName = userName;
        time = System.currentTimeMillis() / 1000;
        code = getCode(4);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     * 描述: 定义一个获取随机验证码的方法：getCode();
     *
     * @author LJH-1755497577 2019/8/29 15:25
     * @param n 字符串长度
     * @return java.lang.String
     */
    private String getCode(int n) {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int index = random.nextInt(string.length());
            ch[i] = string.charAt(index);
        }

        String result = String.valueOf(ch);
        return result;
    }

}
