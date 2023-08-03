package com.just_board.just_board.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
        .csrf().disable()
        .authorizeHttpRequests(authrize-> authrize.requestMatchers("/admin/**").hasAnyRole("ADMIN"))
        .authorizeHttpRequests(authrize-> authrize.requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")     
        .anyRequest().permitAll());
        return http.build();
    }
    
        @Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
