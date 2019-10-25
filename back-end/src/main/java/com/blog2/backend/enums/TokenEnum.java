package com.blog2.backend.enums;

import jdk.nashorn.internal.parser.Token;
import lombok.Getter;

/**
 * @Author: goodtimp
 * @Date: 2019/10/24 11:34
 * @description :
 */
@Getter
public enum TokenEnum {
    ACCESS_TOKEN_EXPIRE_TIME("token过期时间(s)", "30"),
    PAYLOAD_USER_TAG("token有效载荷中用户Id标识", "userId"),
    PAYLOAD_ROLE_TAG("token有效载荷中角色Id标识（逗号隔开）", "roleIds"),
    PAYLOAD_CREATE_TIME_TAG("token有效载荷中创建时间标识", "createTime"),
    REFRESH_TOKEN_EXPIRE_TIME("refreshToken有效载荷中创建时间标识(s)（7天）", "604800"),
    ENCRYPT_JWT_KEY("JWT认证加密私钥(Base64加密)后的值", "bXklMjBuYW1lJTIwaXMlMjBnb29kdGltcA=="),
    SHIRO_CACHE_EXPIRE_TIME("Shiro缓存过期时间-5分钟-5*60(秒为单位)(一般设置与AccessToken过期时间一致)", "30");
    private String name;
    private String code;

    TokenEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
