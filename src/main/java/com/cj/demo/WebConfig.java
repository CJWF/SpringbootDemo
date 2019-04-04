package com.cj.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import com.cj.demo.common.Filter.SessionFilter;
import com.cj.demo.common.Interceptor.BasePathInterceptor;
import com.github.pagehelper.PageHelper;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 注册fastJson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

    /**
     * 注册过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration1() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter( new SessionFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        return registration;
    }

    /**
     * 注册拦截器
     * @return
     */
    @Bean
    public BasePathInterceptor getBasePathInterceptor() {
        return new BasePathInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册获取根路径拦截器
        InterceptorRegistration getBasePathAddInterceptor = registry.addInterceptor(getBasePathInterceptor());
        // 排除配置
        getBasePathAddInterceptor.excludePathPatterns("/error");
        getBasePathAddInterceptor.excludePathPatterns("/login**");
        // 拦截配置
        getBasePathAddInterceptor.addPathPatterns("/**");
    }


    /**
     * 配置mybatis的分页插件pageHelper
     * @return
     */
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }


//    @Bean
//    public MessageSource messageSource(){
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        Properties properties = new Properties();
//        properties.setProperty("classpath:ValidationMessages", StandardCharsets.UTF_8.name());
//        messageSource.setFileEncodings(properties);
//        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
//        messageSource.setCacheSeconds(10);
//        return messageSource;
//    }

}