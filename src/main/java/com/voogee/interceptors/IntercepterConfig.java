package com.voogee.interceptors;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> patterns = new ArrayList<>();
        patterns.add("");

        //addPathPatterns用于添加拦截路径
        //excludePathPatterns用于添加不拦截的路径
        registry.addInterceptor(new LoginCheckHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }

}
