package com.div.ecommerce.ecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderConfig {
    @Bean
    BCryptPasswordEncoder encoder(String password){
        return new BCryptPasswordEncoder(10);
    }
}

