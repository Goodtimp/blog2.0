package com.blog2.backend.config;

import com.blog2.backend.shiro.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: goodtimp
 * @Date: 2019/10/9 9:17
 * @description :
 */
@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean 为Shiro过滤器工厂类
     * 配置一些过滤路径
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);        //设置安全管理器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *    常用的过滤器：
         *       anon: 无需认证（登录）可以访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perms： 该资源必须得到资源权限才可以访问
         *       role: 该资源必须得到角色权限才可以访问
         */

//        shiroFilterFactoryBean.setLoginUrl("/login");// 	如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
//        shiroFilterFactoryBean.setSuccessUrl("/index"); //  登录成功后要跳转的链接
//        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");//未授权界面;
//        Map<String, String> filterMap = new HashMap<String, String>();
//        filterMap.put("/css/**","anon");
//        filterMap.put("/layui/**","anon");
//        filterMap.put("/img/**","anon");
//        filterMap.put("/js/**","anon");
//        filterMap.put("/html/**","anon");
//        filterMap.put("/login/index","authc");
//        filterMap.put("/login/login","anon");
//        filterMap.put("/logout","logout");//配置退出 过滤器,其中的具体的退出代码Shiro已经实现
//        filterMap.put("/**","authc");//过滤链定义，从上向下顺序执行，一般将/**放在最为下边
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;

    }

    /**
     * SecurityManager 为shiro安全管理器，管理着所有的Subject
     *
     * @return
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm) {
        //配置 SecurityManager 并注入 shrioRealm
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);
        return securityManager;
    }

    /**
     * 引入自己实现的 ShiroRealm
     *
     * @return
     */
    @Bean(name = "shiroRealm")
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(matcher());
        return shiroRealm;
    }

    /**
     * 设置加密算法
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher matcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5"); //设置加密算法
        matcher.setHashIterations(2);//设置加密算法的次数
        return matcher;
    }


}
