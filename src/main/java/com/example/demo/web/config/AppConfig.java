package com.example.demo.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
public class AppConfig {
    ApplicationContext context;

    @Autowired
    public AppConfig(ApplicationContext context) { this.context = context; }

    @Bean
    public UrlBasedViewResolver viewJsResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/webapp/js/");
        resolver.setSuffix(".js");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public UrlBasedViewResolver viewJsfResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/webapp/jsf/");
        resolver.setSuffix(".jsf");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public UrlBasedViewResolver viewJspResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/webapp/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
