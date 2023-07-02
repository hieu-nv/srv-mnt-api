package com.sms.api.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
        authz ->
            authz
                .requestMatchers(HttpMethod.GET, "/api/**")
                .authenticated()
                .requestMatchers("/api/**")
                .authenticated()
                .anyRequest()
                .permitAll());
    http.oauth2Login(Customizer.withDefaults());
    http.oauth2ResourceServer(Customizer.withDefaults());
    http.oauth2ResourceServer(
        (oauth2ResourceServerCustomizer) -> {
          oauth2ResourceServerCustomizer.jwt(
              (jwtCustomizer) -> {
                jwtCustomizer.jwtAuthenticationConverter(new KeycloakJwtAuthenticationConverter());
              });
        });

//    http.sessionManagement(
//        (sessionManagementCustomizer) ->
//            sessionManagementCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.cors((corsCustomizer) -> corsCustomizer.disable());
    return http.build();
  }
}
