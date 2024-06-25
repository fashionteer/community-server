package com.fashionteer.application.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private static final String[] MVC_PATHS = {
            "/sign-up"
    };

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().requestMatchers(
                MVC_PATHS
        );
    }
}
