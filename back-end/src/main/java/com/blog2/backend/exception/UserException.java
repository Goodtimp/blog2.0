package com.blog2.backend.exception;

/**
 * @Author: goodtimp
 * @Date: 2019/10/25 9:57
 * @description :  用户异常
 */
public class UserException extends RuntimeException{
    public UserException(String msg) {
        super(msg);
    }

    public UserException() {
        super();
    }
}
