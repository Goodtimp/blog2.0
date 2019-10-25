package com.blog2.backend.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: goodtimp
 * @Date: 2019/10/24 11:14
 * @description :  base64处理
 */
public class Base64ConvertUtil {

    /**
     * 加密JDK1.8
     *
     * @param str
     * @return java.lang.String
     * @author dolyw.com
     * @date 2018/8/21 15:28
     */
    public static String encode(String str) throws UnsupportedEncodingException {
        byte[] encodeBytes = Base64.getEncoder().encode(str.getBytes("utf-8"));
        return new String(encodeBytes);
    }

    /**
     * 解密JDK1.8
     *
     * @param str
     * @return java.lang.String
     * @author dolyw.com
     * @date 2018/8/21 15:28
     */
    public static String decode(String str) throws UnsupportedEncodingException {
        byte[] decodeBytes = Base64.getDecoder().decode(str.getBytes("utf-8"));
        return new String(decodeBytes);
    }

}
