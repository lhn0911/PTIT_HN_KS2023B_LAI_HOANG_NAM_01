package com.rikkei.ptit_hn_ks23b_laihoangnam_01.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.rikkei.ptit_hn_ks23b_laihoangnam_01.controller",
        "com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository",
        "com.rikkei.ptit_hn_ks23b_laihoangnam_01.service"
})
public class AppConfig {
    private static final Object HOST_NAME = "dqodyytc6";
    private static final Object API_KEY = "579886866183763";
    private static final Object API_SECRET = "UjDW8SYuISy9uFl8cS2L4ztLd0s";


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver mResolver = new CommonsMultipartResolver();
        mResolver.setMaxUploadSizePerFile(1024 * 1024 * 10);
        mResolver.setMaxUploadSize(1024 * 1024 * 30);
        return mResolver;
    }
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", HOST_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET,
                "secure", true
        ));
    }



}
