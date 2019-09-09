package com.cqut.minishop.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EntityIDUtil {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static String preId = "";

    /**
     * 实体类ID生成器
     * @return id
     */
    public static synchronized String createId() {
        String id = format.format(Calendar.getInstance().getTime());
        while (id.equals(preId)) {
            id = format.format(Calendar.getInstance().getTime());
        }
        preId = id;
        return id;
    }


    public static void main(String[] args) {
        System.out.println(createId());
    }
}