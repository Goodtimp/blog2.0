package com.blog2.backend.shiro;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.blog2.backend.Common.FormatCheck;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.login.AccountNotFoundException;

/**
 * @Author: goodtimp
 * @Date: 2019/10/7 20:46
 * @description :  shiro认证
 */

public class ShiroReam extends AuthorizingRealm {

    @Autowired
    private UserService userServiceImpl;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 登录认证,验证用户名密码是否正确
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = usernamePasswordToken.getPassword().toString();

        if (StringUtils.isEmpty(username)) {
            throw new AccountException("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new AccountException("密码不能为空");
        }
        User user = userServiceImpl.login(username, password);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码不正确");
        }

        // user.getUserPassword() 应该是数据库对应的加密后的密码字段
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), user.getUserName());
        // principal:用户主体（代表用户，可用id,username,或者一个实例对象）
        // credentials:用户凭证（使用从数据库中查询出来的密码）
        // realmName:获取主体和凭据的域：调用父类方法getName()即可获得。
        // 这里生成的SimpleAuthenticationInfo
    }
}
