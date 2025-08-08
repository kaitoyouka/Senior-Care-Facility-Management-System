package com.cy.config;

import com.cy.interceptor.CheckTokenInterceptor;
import com.cy.utils.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 解决跨域问题
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CheckTokenInterceptor checkTokenInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    // 拦截校验Token
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
                .addPathPatterns("/**")    // 拦截所有的url
                .excludePathPatterns("/user/login", "/swagger-resources/**", "/doc.html", "/webjars/**",
                        "/v3/api-docs/**", "swagger-ui.html", "/images/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")    // 允许跨域的域名，可以用*通配符，表示允许所有域名
                .allowedMethods("*")    // 允许任何方法(POST\GET\PUT\DELETE\OPTIONS等)
                .allowedHeaders("*")    // 允许任何请求头
                .maxAge(3600L);     // 表明在3600秒内，不需要再发送预检验请求，可以缓存该结果
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加静态资源映射
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/META-INF/resources/");
    }
}
