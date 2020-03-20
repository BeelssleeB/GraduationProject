package com.ls.project.config.shiro;

import com.ls.project.utils.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro内置过滤器
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        filterMap.put("/css/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/system/**","anon");

        filterMap.put("/warehouse/info/**","perms[warehouse::info]");
        filterMap.put("/tool/type/**","perms[tool::type]");
        filterMap.put("/tool/ledger/**","perms[tool::ledger]");
        filterMap.put("/tool/storage/**","perms[tool::storage]");
        filterMap.put("/tool/borrowing/**","perms[tool::borrowing]");
        filterMap.put("/worksheet/info/**","perms[worksheet::info]");
        filterMap.put("/worksheet/type/**","perms[worksheet::type]");
        filterMap.put("/worksheet/log/**","perms[worksheet::log]");
        filterMap.put("/vehicle/info/**","perms[vehicle::info]");
        filterMap.put("/vehicle/borrowing/**","perms[vehicle::borrowing]");
        filterMap.put("/node/info/**","perms[node::info]");
        filterMap.put("/node/dis/**","perms[node::dis]");
        filterMap.put("/sys/user/**","perms[sys::user]");
        filterMap.put("/sys/file/**","perms[sys::file]");
        filterMap.put("/sys/log/**","perms[sys::log]");
        filterMap.put("/sys/role/**","perms[sys::role]");

        filterMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        securityManager.setRememberMeManager(rememberMeManager());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    //密码加密
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(3);
        return hashedCredentialsMatcher;
    }

    //rememberMe
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        //setCipherKey用来设置加密的Key,参数类型byte[],字节数组长度要求16
        cookieRememberMeManager.setCipherKey("da45F56SIO5sa4r0".getBytes());
        return cookieRememberMeManager;
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置session过期时间 单位:ms
        sessionManager.setGlobalSessionTimeout(1800000L);
        return sessionManager;
    }
}
