package com.just_board.just_board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {
    @Bean
    WebMvcConfigurer webMvcConfigurer(){

            WebMvcConfigurer Configurer = new WebMvcConfigurer(){
                
                @Override
                public void addCorsMappings(CorsRegistry registry){

                    registry
                        .addMapping("/**")
                        .allowedMethods("*") // put delete 메소드는 CORS 떠서 미리 수정
                        .allowedOrigins("*");
                }
            };

            return Configurer;
    }
}
