package com.dilankag.spring.sbw.config;

import com.dilankag.spring.sbw.modules.role.Role;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfiguration {
    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.csrf().disable().authorizeExchange()
                // Actuator health
                .matchers(EndpointRequest.to("health")).permitAll()
                // Actuator info
                .matchers(EndpointRequest.to("info")).permitAll()
                // Actuator all other
                .matchers(EndpointRequest.toAnyEndpoint()).hasRole(Role.ADMIN.name())

                .pathMatchers(HttpMethod.GET, "/api/bye").hasRole(Role.ADMIN.name())
                .pathMatchers(HttpMethod.POST, "/api/**").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/**").permitAll()
                
                .anyExchange().authenticated()
                .and().oauth2ResourceServer().jwt().jwtAuthenticationConverter(
                        new ReactiveJwtAuthenticationConverterAdapter(new JwtAuthenticationConverter()));
        return http.build();
    }
}