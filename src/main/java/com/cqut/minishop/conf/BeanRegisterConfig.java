package com.cqut.minishop.conf;

import com.cqut.minishop.util.jwt.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LJH
 * @date 2019/7/16-6:16
 * @QQ 1755497577
 */
@Configuration
public class BeanRegisterConfig {

    @Bean
    public FilterRegistrationBean createFilterBean() {
        //过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/user/hello");
        return registration;
    }
}