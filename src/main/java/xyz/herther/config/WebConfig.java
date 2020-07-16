package xyz.herther.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Herther
 * 全局配置类--配置跨域请求
 * 2020.7.12
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter  {

    public void addCorsMappings(CorsRegistry registry, ResourceHandlerRegistry rep) {
        /**
         * 1、预访问路径
         * 2、请求来源
         * 3、请求方法
         * 4、允许携带token
         * 5、响应时间最大3600
         */
        registry.addMapping("/***")
                .allowedOrigins("Http://localhost:88","null")
                .allowedMethods("GET","POST","OPTIONS","DELETE")
                .allowCredentials(true)
                .maxAge(3600);
        rep.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
