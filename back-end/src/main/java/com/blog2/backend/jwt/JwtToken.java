package com.blog2.backend.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author: goodtimp
 * @Date: 2019/10/1 22:22
 * @description :  token
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal(){
        return token;
    }

    @Override
    public Object getCredentials(){
        return token;
    }
}
