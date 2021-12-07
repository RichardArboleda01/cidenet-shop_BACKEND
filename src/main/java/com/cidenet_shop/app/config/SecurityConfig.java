package com.cidenet_shop.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

	// Encryption password method, using BcryptPass
	@Bean
	public BCryptPasswordEncoder passwordEncoder( ) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		return bcrypt;
	}
}
