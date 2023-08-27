package com.apigateway.apigateway.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import jakarta.servlet.ServletSecurityElement;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfiguration {
	
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
		httpSecurity.authorizeExchange()
					.anyExchange()
					.authenticated()
					.and()
					.oauth2Client()
					.and()
					.oauth2ResourceServer()
					.jwt();
		
		return null;
		
	}

}
