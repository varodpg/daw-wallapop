package com.practicaDaw.Dawllapop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebMvcConfig {

    @Bean
    public WebMvcConfigurerAdapter forwardToIndex() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/new").setViewName("forward:/new/index.html");
                registry.addViewController("/new/singleProduct/*").setViewName("forward:/new/index.html");
                registry.addViewController("/new/category/*").setViewName("forward:/new/index.html");
                registry.addViewController("/new/category").setViewName("forward:/new/index.html");
                registry.addViewController("/new/addProduct").setViewName("forward:/new/index.html");
                registry.addViewController("/new/dashboard").setViewName("forward:/new/index.html");
                registry.addViewController("/new/login").setViewName("forward:/new/index.html");
                registry.addViewController("/new/publicDashboard/*").setViewName("forward:/new/index.html");
                registry.addViewController("/new/search/*").setViewName("forward:/new/index.html");
                registry.addViewController("/new/edit/*").setViewName("forward:/new/index.html");
                registry.addViewController("/new/editUser/*").setViewName("forward:/new/index.html");
                

            }
        };
    }
}