package com.blog2.backend.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.blog2.backend.common.utils.Base64ConvertUtil;
import com.blog2.backend.enums.RedisEnum;
import com.blog2.backend.enums.TokenEnum;
import com.blog2.backend.exception.TokenException;
import com.blog2.backend.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static com.blog2.backend.enums.TokenEnum.*;

/**
 * @Author: goodtimp
 * @Date: 2019/10/1 22:44
 * @description :  jwt工具类
 */
public class JwtUtil {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    /**
     * 验证token是否正确
     *
     * @param token
     * @return
     */
    public static boolean verify(String token) {
        try {
            // 帐号加JWT私钥解密
            String secret = getClaim(token, PAYLOAD_USER_TAG.getCode()) + Base64ConvertUtil.decode(ENCRYPT_JWT_KEY.getCode());
            Algorithm algorithm = Algorithm.HMAC256(secret);  // 解密 验证正确性
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            logger.error("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new TokenException("JWTToken认证解密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }

//    public static boolean judgeOverExpire(String token)
//    {
//        try{
//            getClaim(token, PAYLOAD_CREATE_TIME_TAG.getCode());
//        }
//    }
    /**
     * 获得Token中的信息无需secret解密也能获得
     *
     * @param token
     * @param claim
     * @return java.lang.String
     * @date 2018/9/7 16:54
     */
    public static String getClaim(String token, String claim) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            // 只能输出String类型，如果是其他类型返回null
            return jwt.getClaim(claim).asString();
        } catch (JWTDecodeException e) {
            logger.error("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
            throw new JWTDecodeException("解密Token中的公共信息出现JWTDecodeException异常:" + e.getMessage());
        }
    }

    /**
     * 生成签名 todo:需要加角色信息
     *
     * @param userId            帐号id
     * @param currentTimeMillis
     * @return 返回加密的Token
     */
    public static String sign(String userId, String currentTimeMillis) {
        try {
            // 帐号加JWT私钥加密
            String secret = userId + Base64ConvertUtil.decode(ENCRYPT_JWT_KEY.getCode());
            // 此处过期时间是以毫秒为单位，所以乘以1000
            Date date = new Date(System.currentTimeMillis() + Long.parseLong(ACCESS_TOKEN_EXPIRE_TIME.getCode()) * 1000L);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            // 附带account帐号信息
            return JWT.create()
                    .withClaim(PAYLOAD_USER_TAG.getCode(), userId)
                    .withClaim(PAYLOAD_CREATE_TIME_TAG.getCode(), currentTimeMillis)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            logger.error("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
            throw new JWTDecodeException("JWTToken加密出现UnsupportedEncodingException异常:" + e.getMessage());
        }
    }

    /**
     * 根据token判断refreshToken是否存在和 正确
     *
     * @param token
     * @return
     */
    public static boolean judgeRefreshToken(String token, String refreshToken) {
        // 判断token创建时间与refreshToken记录的时间是否相同
        return getClaim(token, PAYLOAD_CREATE_TIME_TAG.getCode()).equals(refreshToken);
    }

}