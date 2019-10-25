package com.blog2.backend.exception;

/**
 * @Author: goodtimp
 * @Date: 2019/10/24 11:03
 * @description :  token错误
 */
public class TokenException extends RuntimeException {
    public TokenException(String msg) {
        super(msg);
    }

    public TokenException() {
        super();
    }
}
