package com.dilankag.spring.sbw.security;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.util.Assert;

import reactor.core.publisher.Mono;

/**
 * SbwReactiveAuthenticationManager
 */
public class SbwReactiveAuthenticationManager implements ReactiveAuthenticationManager {

    private final ReactiveJwtDecoder jwtDecoder;

    public SbwReactiveAuthenticationManager(ReactiveJwtDecoder jwtDecoder) {
        Assert.notNull(jwtDecoder, "jwtDecoder cannot be null");
        this.jwtDecoder = jwtDecoder;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return null;
    }
}