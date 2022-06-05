package com.miu.edu.cs590.applicationgateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		http.csrf().disable()
				.authorizeExchange()
				.pathMatchers("/actuator/**","/pay-pal/**","/account/**")
				.permitAll()
				.pathMatchers("/credit-card/**","/order/**","/products/").permitAll()
			.and()
				.authorizeExchange()
				.anyExchange()
				.authenticated();
//			.and()
//				.oauth2Login(); // to redirect to oauth2 login page.

		return http.build();
	}

}