package com.blog2.backend.shiro;

import com.blog2.backend.common.utils.StringUtil;
import com.blog2.backend.enums.RedisEnum;
import com.blog2.backend.enums.TokenEnum;
import com.blog2.backend.jwt.JwtToken;
import com.blog2.backend.jwt.JwtUtil;
import com.blog2.backend.model.entity.User;
import com.blog2.backend.redis.RedisUtil;
import com.blog2.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.blog2.backend.enums.TokenEnum.PAYLOAD_ROLE_TAG;
import static com.blog2.backend.enums.TokenEnum.PAYLOAD_USER_TAG;

/**
 * @Author: goodtimp
 * @Date: 2019/10/7 20:46
 * @description :  shiro认证
 */
@Service
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ShiroRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(getClass());
    final private UserService userServiceImpl;
    final private RedisUtil redisUtil;

    /**
     * 必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     *
     * @param principalCollection doGetAuthenticationInfo中传的token
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String userId = JwtUtil.getClaim(principalCollection.toString(), PAYLOAD_USER_TAG.getCode());

        String roleIds = JwtUtil.getClaim(principalCollection.toString(), PAYLOAD_ROLE_TAG.getCode());

        // 从redis中获取角色对应的数据
        // ------- code --------

        simpleAuthorizationInfo.addStringPermission("user:test");

        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        // 解密获得account，用于和数据库进行对比
        String userId = JwtUtil.getClaim(token, PAYLOAD_USER_TAG.getCode());
        // 帐号为空
        if (StringUtil.isBlank(userId)) {
            throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
        }
        // 查询用户是否存在 todo: 是否可以去除用户查询，当删除用户时refreshToken也会被删除？
//        User user = userServiceImpl.getById(Long.parseLong(userId));
//        if (user == null) {
//            throw new AuthenticationException("该帐号不存在(The account does not exist.)");
//        }
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        String refreshToken = (String) redisUtil.get(RedisEnum.REFRESH_TOKEN_PREFIX.getCode() + userId);
        if (JwtUtil.verify(token) && JwtUtil.judgeRefreshToken(token, refreshToken)) {
            return new SimpleAuthenticationInfo(token, token, "userRealm");
        }
        throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }

}
