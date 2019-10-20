package com.blog2.backend.shiro;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.service.UserService;
import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: goodtimp
 * @Date: 2019/10/7 20:46
 * @description :  shiro认证
 */

public class ShiroRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(getClass());
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
        String username = (String) usernamePasswordToken.getPrincipal();
        String password = new String((char[]) (usernamePasswordToken.getCredentials()));  // 无法通过.toString转换

        logger.debug("用户登陆账号：" + username);
        logger.debug("用户登陆密码：" + password);
        if (StringUtils.isEmpty(username)) {
            throw new AccountException("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new AccountException("密码不能为空");
        }
        User user = userServiceImpl.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码不正确");
        }
        // user.getUserPassword() 应该是数据库对应的加密后的密码字段
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        // principal:用户主体（代表用户，可用id,username,或者一个实例对象）
        // credentials:用户凭证（使用从数据库中查询出来的密码）
        // realmName:获取主体和凭据的域：调用父类方法getName()即可获得。
        // 这里生成的SimpleAuthenticationInfo
    }
}
