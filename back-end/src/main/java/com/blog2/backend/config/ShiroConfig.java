//package com.blog2.backend.config;
//
//import com.blog2.backend.shiro.ShiroRealm;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//
///**
// * @Author: goodtimp
// * @Date: 2019/10/9 9:17
// * @description :
// */
//@Configuration
//public class ShiroConfig {
//    /**
//     * ShiroFilterFactoryBean 为Shiro过滤器工厂类
//     * 配置一些过滤路径
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //设置
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//        //配置shiro默认登录界面地址，前后端分离中登录界面跳转由端控制，后台仅返回json数据
//        shiroFilterFactoryBean.setLoginUrl("/unauth.action");
//        // 登录成功后跳转的url
////        shiroFilterFactoryBean.setSuccessUrl("/index");
//        // 未授权url
////        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//
//        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//        //注意过滤器配置顺序 不能颠倒
//        // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
////        前后端分离自己实现
////        filterChainDefinitionMap.put("/logout", "logout");
//        filterChainDefinitionMap.put("/login.action", "anon");
//        filterChainDefinitionMap.put("/", "anon");
//        //解析不需要认证
//        filterChainDefinitionMap.put("/resolve", "anon");
//        // 需要认证的url
//        filterChainDefinitionMap.put("/**.action", "authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * SecurityManager 为shiro安全管理器，管理着所有的Subject
//     *
//     * @return
//     */
//    @Bean
//    public SecurityManager securityManager() {
//        //配置 SecurityManager 并注入 shrioRealm
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(shiroRealm());
//        return securityManager;
//    }
//
//    /**
//     * 引入自己实现的 ShiroRealm
//     *
//     * @return
//     */
//    @Bean
//    public ShiroRealm shiroRealm() {
//        ShiroRealm shiroRealm = new ShiroRealm();
//        shiroRealm.setCredentialsMatcher(matcher());
//        return shiroRealm;
//    }
//
//    /**
//     * 设置加密算法
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher matcher() {
//        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
//        matcher.setHashAlgorithmName("md5"); //设置加密算法
//        matcher.setHashIterations(1);//设置加密算法的次数
//        return matcher;
//    }
//
//}
//}
