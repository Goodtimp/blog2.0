package com.blog2.backend.enums;

import lombok.Getter;

/**
 * @Author: goodtimp
 * @Date: 2019/10/24 12:58
 * @description :  redis枚举类
 */
@Getter
public enum RedisEnum {

    REFRESH_TOKEN_PREFIX("refresh token的前缀", "token:refresh:"),
    SHIRO_CACHE_PERFIX("shiro缓存的前缀", "shiro:cache:");
    private String name;
    private String code;

    RedisEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
