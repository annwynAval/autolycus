package com.annwyn.autolycus;

import com.annwyn.autolycus.common.configuration.DefaultLocaleResolver;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.Validator;


@Component
public class AutolycusServletInitializer extends SpringBootServletInitializer implements WebMvcConfigurer {

    @Bean
    public Validator validator() {
        return Validation.byProvider(HibernateValidator.class)
                .configure().failFast(true)
                .buildValidatorFactory().getValidator();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(corsConfigurationSource);
    }

    // @Bean
    // public MessageSource messageSource() {
    //     ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    //     messageSource.setBasename("classpath:autolycus-backend-message");
    //     messageSource.setDefaultEncoding("utf-8");
    //     return messageSource;
    // }
    //
    // @Bean
    // public LocaleResolver localeResolver() {
    //     return new DefaultLocaleResolver();
    // }

}
