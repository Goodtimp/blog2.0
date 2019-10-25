package com.blog2.backend.enums;

import lombok.Getter;

/**
 * @Author: goodtimp
 * @Date: 2019/10/11 16:04
 * @description :  删除
 */
@Getter
public enum DelFlagEnum {
    NORMAL(0, "正常"),
    DELETE(1, "已删除");

    private int code;
    private String msg;

    DelFlagEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
