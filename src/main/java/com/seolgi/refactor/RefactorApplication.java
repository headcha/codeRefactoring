package com.seolgi.refactor;


import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import com.seolgi.refactor.util.FullBeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableConfigurationProperties
@EnableAutoConfiguration
@ComponentScan(nameGenerator = FullBeanNameGenerator.class)
@PropertySource("classpath:properties/application-${spring.profiles.active}.properties")
public class RefactorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RefactorApplication.class, args);
    }

    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    public FilterRegistrationBean xssEscapeServletFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
