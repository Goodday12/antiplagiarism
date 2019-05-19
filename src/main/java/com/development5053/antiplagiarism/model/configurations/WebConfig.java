/*
 * Dmytro Rybachok
 *
 * This software is a property of Dmytro Rybachok
 */
package com.development5053.antiplagiarism.model.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan("com.development5053.antiplagiarism.*")
public class WebConfig implements WebMvcConfigurer {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }


    @Bean
    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();

//        resourceViewResolver.setViewClass(JstlView);
        resourceViewResolver.setPrefix("/WEB-INF/view/");
        resourceViewResolver.setSuffix(".jsp");

        return resourceViewResolver;
    }
}
