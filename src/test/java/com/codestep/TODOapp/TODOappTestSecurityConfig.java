package com.codestep.TODOapp;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@TestConfiguration
@EnableMethodSecurity

public class TODOappTestSecurityConfig {
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       
       http.csrf(AbstractHttpConfigurer::disable);
       http.headers(headers -> headers
               .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable)); // H2Consoleで必要
       http.authorizeHttpRequests(requests -> requests
               .anyRequest().permitAll()
               );
       http.formLogin(form -> form
               .defaultSuccessUrl("/secret")
               .loginPage("/login"));
       http.logout(LogoutConfigurer::permitAll);

       return http.build();
   }
   
  
}