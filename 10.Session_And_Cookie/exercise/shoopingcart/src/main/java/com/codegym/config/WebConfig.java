package com.codegym.config;

import com.codegym.entity.ShoppingCart;
import com.codegym.entity.User;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.AnnotationUtils;

@Configuration
public class WebConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("validation/message");
        return messageSource;
    }

}
