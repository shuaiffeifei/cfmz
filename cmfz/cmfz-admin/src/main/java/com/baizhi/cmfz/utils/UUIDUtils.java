package com.baizhi.cmfz.utils;

/**
 * @Description UUID工具类
 * @Author Administrator
 * @Time 2018/7/6 9:45
 */
public class UUIDUtils {
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replace("-","");
    }
    public static void main(String[] args) {
        System.out.println(java.util.UUID.randomUUID());
        System.out.println(getUUID());
    }
}
