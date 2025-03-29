package com.secure_book_review.secure_book_review.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration

public class SecurityConfig {
    // Add your security configuration here
    // For example, you can configure authentication, authorization, etc.

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{

            http.
                    csrf(csrf->csrf.disable())

                    .authorizeHttpRequests(request->request
                            .requestMatchers("/api/v1/register","/api/v1/hello").permitAll()
                            .requestMatchers("/api/v1/users").hasRole("ADMIN")
                    .anyRequest().authenticated())
                    .formLogin(Customizer.withDefaults())
                    .httpBasic(Customizer.withDefaults());

            return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
