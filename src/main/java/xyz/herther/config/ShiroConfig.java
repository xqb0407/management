package xyz.herther.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Herther
 * shiroCofing配置类
 * 2020.7.11
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建过滤器
     * ShiroFilterfactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterfactoryBean(@Qualifier("WebSecurityManager") DefaultWebSecurityManager WebSecurityManager){
        ShiroFilterFactoryBean FilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        FilterFactoryBean.setSecurityManager(WebSecurityManager);

        /**
         *Shiro内置过滤器，可以实现权限相关拦截
         * 常用的过滤器：
         * anon：无需认证（登录可以访问）
         * authc：必须认证才可以访问
         * user：如果使用rememberMe的功能才可以直接访问
         * perms:该资源必须得到权限才能访问
         * role：该资源必须得到角色的权限才可以访问
         */
        LinkedHashMap map = new LinkedHashMap<String,String>();
        FilterFactoryBean.setFilterChainDefinitionMap(map);
        map.put("/*", "authc");

        FilterFactoryBean.setLoginUrl("/tologin");
        return FilterFactoryBean;
    }


    /**
     * 创建安全管理器
     * DeafultWebSecurityManager
     */
    @Bean(name = "WebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userReaml")UserReaml userReaml){
        DefaultWebSecurityManager SecurityManager = new DefaultWebSecurityManager();
        //关联Reaml
        SecurityManager.setRealm(userReaml);
        return SecurityManager;
    }

    /**
     * 创建Reaml
     */
    @Bean(name="userReaml")
    public UserReaml getReaml(){
        return new UserReaml();
    }
}
