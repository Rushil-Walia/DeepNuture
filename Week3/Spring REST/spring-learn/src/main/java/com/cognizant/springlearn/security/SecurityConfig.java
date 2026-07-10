package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        LOGGER.info("Start");
        UserDetails admin = User.withUsername("admin")
                .password("{noop}pwd") // Using {noop} instead of BCrypt for learning simplicity
                .roles("ADMIN")
                .build();
        
        UserDetails user = User.withUsername("user")
                .password("{noop}pwd")
                .roles("USER")
                .build();
        
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Start filterChain");
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/countries").hasRole("USER")
                .requestMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults())
            // Added JWT Filter
            .addFilter(new JwtAuthorizationFilter(http.getSharedObject(org.springframework.security.authentication.AuthenticationManager.class)));
        
        return http.build();
    }
}
